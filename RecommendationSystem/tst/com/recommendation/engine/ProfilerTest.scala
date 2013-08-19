package com.recommendation.engine

import org.junit.Test

class ProfilerTest {
  //TODO Add more test cases
  @Test
  def splitLineTest(){
    val line = ("one\ttwo\t1.0")
    val tuple=("one","two",1.0)
    assert(tuple==Profiler.splitLine(line))
  }

}