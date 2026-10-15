package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Try Catch Example1 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class TryCatchExample1 {
  
    public static void main(String[] args) {  
          
        int data=50/0; //may throw exception   
          
        System.out.println("rest of the code");  
          
    }  
      
}  