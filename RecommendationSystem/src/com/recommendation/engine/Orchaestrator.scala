package com.recommendation.engine

import com.recommendation.profile.Profile
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.FileInputStream
import scala.collection.mutable.HashMap
import scala.util.Try
import com.recommendation.utils.logger
import com.recommendation.profile.Profile
import java.io.FileNotFoundException
import com.recommendation.similarity.Similarity

object Orchaestrator extends logger {
  
  
  
  def main(args : Array[String]){
    val profileMap =Profiler.setUpProfiles(args(0))
    
    profileMap foreach {entryX =>
      profileMap foreach {entryY =>
        if(entryY!= entryX)Similarity.pearson(entryX._2, entryY._2)
      }
      
    }
  }
  
}