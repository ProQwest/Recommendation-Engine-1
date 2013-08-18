package com.recommendation.utils

import java.io.BufferedReader
import java.io.FileInputStream
import java.util.zip.GZIPOutputStream
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.FileNotFoundException

object FileUtils {
  
  
  def writeToFile(filePath : String , item : String){
    val writer = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(filePath,true))))
    try{
      writer.write(item)
    }catch{
      case e : FileNotFoundException =>
    }finally{
      writer.close()
    } 
  }

}