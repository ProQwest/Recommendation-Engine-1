package com.recommendation.utils

object CalcUtils {
  
  //TODO more comments here
  def calculateAvgRating(collection : Map[String,Double]):Double={
    collection.toList.foldLeft(0.0)(_ + _._2)/collection.size
  }

}