package com.recommendation.engine

import scala.collection.mutable.HashMap

import com.recommendation.profile.Profile
import com.recommendation.similarity.Similarity
import com.recommendation.utils.logger

object Orchaestrator extends logger {

  def main(args: Array[String]) {
    val profileMap = Profiler.setUpProfiles(args(0))
    calculateSimilarity(profileMap)

    
    profileMap foreach { entryX =>
      var normFactor = 0.0
      profileMap foreach { entryY =>
        if (entryY != entryX) {
          val sim = entryX._2.similarityMap.get(entryY._1).get
          normFactor += sim.abs
          entryY._2.ratingMap foreach { ratedItem =>
            if (!entryX._2.ratingMap.contains(ratedItem._1)) {
              entryX._2.predictedRatingMap.get(ratedItem._1) match {
                case Some(predictedItem) =>
                  val predict = sim * (ratedItem._2 - entryY._2.avgRating)
                  entryX._2.predictedRatingMap.put(ratedItem._1, predictedItem + predict)

                case None =>
                  val predict = sim * (ratedItem._2 - entryY._2.avgRating)
                  entryX._2.predictedRatingMap.put(ratedItem._1, predict)
              }
            }
          }
        }
      }
      normFactor = 1/normFactor
      entryX._2.predictedRatingMap = entryX._2.predictedRatingMap map { predicted =>
         (predicted._1,entryX._2.avgRating + normFactor * predicted._2)
      }
    }
  }

  /**
   * Calculates each profiles similarity w.r.t others
   * TODO : can leverage the double loop for reuse
   */
  private def calculateSimilarity(profileMap: HashMap[String, Profile]): Unit = {

    profileMap foreach { entryX =>
      profileMap foreach { entryY =>
        if (entryY != entryX) Similarity.pearson(entryX._2, entryY._2)
      }
    }
  }
  
}