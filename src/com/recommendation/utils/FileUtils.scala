package com.recommendation.utils

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

import scala.util.Try

object FileUtils extends logger {
  
  /**
   * writes a string into a file and adds a return statement.
   * i.e writes a single line into file
   * If the file already exists the content is appended by default
   * overide this by passing false for append
   * 
   * @param filePath String specifying the path to the file to be written
   * @param item String to be written into file
   * @param append boolean value specifying whether the file has to be appended or truncated
   * 
   * @return Try[Unit] to allow the user handle exit scenario
   */
  def writeToFile(filePath : String , item : String,append : Boolean=true)=Try{
    try{
      val writer = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(filePath,append))))
      writer.write(item+"\n")
      writer.close()
      logger.debug(s"Finished writing ${item} into ${filePath}")
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
   * Reads data from file given filepath one line at a time. and returns a list of these lines
   * 
   * @param filePath String specifying the location of the file to be read
   * 
   * @returns Try[List[String]] each entry in the list corresponds to a line in the file
   */
  def readFromFile(filePath : String): Try[List[String]]=Try{
    var list =List[String]()
    try{
      val reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(filePath))))
      var line = reader.readLine()
      while(line !=null){
        list ::=line
        line= reader.readLine()
      }
      logger.debug(s"Finished reading ${filePath}. There were ${list.length} lines n the file")
      list
    }catch{
      case e : FileNotFoundException =>
        logger.error(s"${filePath} not found.",e)
    	throw e
      case e : Exception =>
        logger.error("Exception found", e)
        throw e
    }
  }

}