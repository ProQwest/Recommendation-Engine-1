package com.practice.problems.scala

import scala.util.Try

object Problems99 {
  /**
   * Problem 1: 
   * Find the last element of a list.
   * Function Try's to return the last element of the list.
   * 
   * Method ---> Use tail recursion to traverse list
   * Difficulty Level : Easy
   */
  def findLastElement[T](list : List[T]): Try[T]=Try{
    def tailRecurse(list:List[T]):T={
      if(list.tail==Nil) list.head
      else tailRecurse(list.tail)
    }
    tailRecurse(list)
  }
  
  /**
   * Problem 2:
   * Find the last but one element of a list.
   * 
   * Method ---> tail recursion and check for Nil w.r.t the tail of a lists tail
   * 
   * i.e List(2,3)
   * list.tail==3
   * list.tail.tail==Nil
   */
  
  def findPenultimateElement[T](list:List[T]):Try[T]=Try{
    def tailRecurse(list:List[T]):T={
      if((list.tail).tail==Nil) list.head
      else tailRecurse(list.tail)
    }
    tailRecurse(list)
  }
  
  
  /**
   * Problem 3 
   * FInd the kth element in a list
   * 
   * Method ---> tail Recursion with accumulator
   */
  
  def findKthElement[T](list:List[T],k :Int):Try[T]=Try{
    def tailRecurse(list:List[T],acc:Int):T={
      if(acc==k) list.head
      else tailRecurse(list.tail,acc+1)
    }
    tailRecurse(list,1)
  }
  
  
  /**
   * Problem 4 
   * FInd the length of a list
   * 
   * Method ---> tail Recursion with accumulator
   */
  
  def findLength[T](list:List[T]):Try[Int]=Try{
    def tailRecurse(list:List[T],acc:Int):Int={
      if(list.tail==Nil) acc+1
      else tailRecurse(list.tail,acc+1)
    }
    tailRecurse(list,0)
  }
  
  
  /**
   * Problem 4 
   * Reverse a list
   * 
   * Method ---> tail Recursion with accumulator(list)
   */
  
  def reverse[T](list:List[T]):Try[List[T]]=Try{
    def tailRecurse(list:List[T],acc:List[T]):List[T]={
      if(list.tail==Nil) acc
      else{
        tailRecurse(list.tail,list.head :: acc)
      }
      
    }
    tailRecurse(list,List[T]())
  }
  

}