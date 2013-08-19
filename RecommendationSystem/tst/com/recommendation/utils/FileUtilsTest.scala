package com.recommendation.utils

import org.junit.Test

class FileUtilsTest {
  
  @Test
  def writeTest(){
    assert(FileUtils.writeToFile("test.txt", "first-line", false).isSuccess)
  }
  
  @Test
  def writeTestNeg(){
    assert(FileUtils.writeToFile("nonexistingfile", "first-line", true).isSuccess)
  }
  

}