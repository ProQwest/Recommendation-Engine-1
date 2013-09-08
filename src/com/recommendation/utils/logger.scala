package com.recommendation.utils
import org.apache.log4j.Logger

trait logger {
  val loggername = this.getClass().getName
  val logger = Logger.getLogger(loggername)
}
