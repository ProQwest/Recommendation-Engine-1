package com.practice.problems.scala

import org.junit.Assert._
import org.junit.Test


class TestProblems99 {

  @Test
  def findLastElementTest(){
    assert(4==Problems99.findLastElement(List(1,2,3,4)).get)
    
  }
  
  @Test
  def findLastElementWhenEmptyTest(){
    assert(Problems99.findLastElement(List()).isFailure)
  }
  
  @Test
  def findPenultimateELementTest(){
    assert(3==Problems99.findPenultimateElement(List(1,2,3,4)).get)
    
  }
  
  @Test
  def findPenultimateWhenEmptyTest(){
    assert(Problems99.findPenultimateElement(List()).isFailure)
  }
  
  @Test
  def findKthELementTest(){
    assertEquals(3,Problems99.findKthElement(List(1,2,3,4),3).get)
    
  }
  
  @Test
  def findKthWhenEmptyTest(){
    assert(Problems99.findKthElement(List(),2).isFailure)
  }
  
  @Test
  def findLengthTest(){
    assertEquals(4,Problems99.findLength(List(1,2,3,4)).get)
    
  }
  
  @Test
  def findUnitLengthTest(){
    assertEquals(1,Problems99.findLength(List(1)).get)
    
  }
  
  @Test
  def findLengthWhenEmptyTest(){
    assert(Problems99.findLength(List()).isFailure)
  }
  
  
  
}