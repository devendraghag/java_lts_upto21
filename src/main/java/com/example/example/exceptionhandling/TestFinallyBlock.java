package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Finally Block in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
class TestFinallyBlock {
  public static void main(String args[]){    
  try{    
//below code do not throw any exception  
   int data=25/5;    
   System.out.println(data);    
  }    
//catch won't be executed  
  catch(NullPointerException e){  
System.out.println(e);  
}    
//executed regardless of exception occurred or not  
 finally {  
System.out.println("finally block is always executed");  
}    
    
System.out.println("rest of phe code...");    
  }    
}    