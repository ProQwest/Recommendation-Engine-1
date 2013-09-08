package com.recommendation.similarity

import com.recommendation.profile.Profile
import com.recommendation.utils.logger

object Similarity extends logger {
  //TODO : tests for this
  def pearson(userX :Profile, userY : Profile){
    var numerator =0.0
    var denominator =0.0
    userX.ratingMap foreach{userXentry =>
      userY.ratingMap.get(userXentry._1) match{
        case Some(userYrating) =>
          var deviationX=(userXentry._2 - userX.avgRating)
          var deviationY=(userYrating - userY.avgRating)
          numerator += deviationX * deviationY
          denominator += (deviationX * deviationX) * (deviationY * deviationY)
        case None => 
      } 
    }
    if(denominator!=0){
      val similarity = numerator/denominator
      userX.similarityMap.put(userY.id, similarity)
      logger.debug(s"Similarity of ${userX.id} && ${userY.id} = ${similarity}")
    }
    
  }

}