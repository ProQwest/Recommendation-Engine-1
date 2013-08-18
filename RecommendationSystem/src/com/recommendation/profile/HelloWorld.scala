package com.recommendation.profile
import org.apache.log4j.Logger

trait logger {
  val loggername = this.getClass().getName
  val log = Logger.getLogger(loggername)
}

object HelloWorld extends logger {
  def main(args: Array[String]) {
    
    var x = 10
    log.info("log testing")
    println("log done");
  }
}