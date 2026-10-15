package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Finally Block1 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TestFinallyBlock1{
      public static void main(String args[]){   
  
      try {    
  
        System.out.println("Inside the try block");  
          
        //below code throws divide by zero exception  
       int data=25/0;    
       System.out.println(data);    
      }    
      //cannot handle Arithmetic type exception  
      //can only accept Null Pointer type exception  
      catch(NullPointerException e){  
        System.out.println(e);  
      }   
  
      //executes regardless of exception occured or not   
      finally {  
        System.out.println("finally block is always executed");  
      }    
  
      System.out.println("rest of the code...");    
      }    
    }  