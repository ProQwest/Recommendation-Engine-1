package com.recommendation.engine

import com.recommendation.utils.logger
import java.io.BufferedReader
import java.io.FileNotFoundException
import com.recommendation.profile.Profile
import scala.collection.mutable.HashMap
import java.io.InputStreamReader
import java.io.FileInputStream
 /**
   * reads  profile info from file and sets up objects for each id
   * 
   * @author Prashanth Ramanna
   */
object Profiler extends logger {

  var profileMap = new HashMap[String,Profile] //TODO fix this
  
  def setUpProfiles(filePath : String)={
    try{
      val reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))
      var line =reader.readLine()
      while(line!=null){
        profiler(line)
        line = reader.readLine()
      }
      logger.info(s"${profileMap.size} profiles setup from ${filePath}")
      profileMap
    }catch{
      case e : FileNotFoundException =>
        logger.error(s"${filePath} not found.",e)
    	throw e
      case e : Exception =>
        logger.error("Exception found", e)
        throw e
    }
  }
  
  /**
   * Updates the profileMap with new profile for a user or updates existing profile with
   * rating for a new item
   * 
   * @param line String containing tab seperated entries for a user and rating for the item.
   * 
   * 
   */
  def profiler(line : String){
    val (profileID,itemID,itemRating) = splitLine(line)
    profileMap.get(profileID) match {
      case Some(profile) => 
        logger.debug(s"adding ratingHistory for profileID ${profileID}")
    	profile.ratingMap.put(itemID, itemRating)
      case None => 
        logger.debug(s"Creating profile for ${profileID}")
        val profile = new Profile(profileID)
      	profile.ratingMap.put(itemID,itemRating)
      	profileMap.put(profileID, profile)
    }
  }
  
  //TODO use Try 
  def splitLine(line: String)={
    val splitArray = line.split("\t")
    ((splitArray(0),splitArray(1),splitArray(2).toDouble))
  }
}