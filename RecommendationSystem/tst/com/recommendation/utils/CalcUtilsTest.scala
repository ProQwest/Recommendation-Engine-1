package com.recommendation.utils

import org.junit.Test
import scala.collection.immutable.HashMap

class CalcUtilsTest {

  @Test
  def calcAvgTest{
    assert(0==CalcUtils.calculateAvgRating(new HashMap[String,Double]()))
  }
}