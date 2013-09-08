package com.recommendation.profile

import scala.collection.mutable.HashMap

class Profile(val id : String){
  
  var ratingMap = new HashMap[String,Double]
  var similarityMap = new HashMap[String,Double]
  var predictedRatingMap = new HashMap[String,Double]
  var avgRating = 0.0
  
}
    



