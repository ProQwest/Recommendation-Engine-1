package com.recommendation.profile

import scala.collection.mutable.HashMap

case class profile(
    id : String,
    contextMap : Map[String,Double],
    similarityMap : Option[Map[String,Double]])


/*
 *1. Create class for storing
 * 	-- profile id
 *  -- map  item id -> rating
 *  
 *2. create load from file
 * list of profiles
 * 
 *3.pass list of profiles to calculate similarity
 * => map for every profile -- id->similarity
 * 
 * 4. apply formula for every movie aggregate against other profiles
 * 
 * 5. get the reccomendation for
 */
