package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


import java.io.*;
/**
 * Easy: Demonstrates Testthrows3 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class M1{
 void method()throws IOException{  
  System.out.println("device operation performed");  
 }  
}  
class Testthrows3{  
   public static void main(String args[])throws IOException{//declare exception  
     M1 m=new M1();
     m.method();  
  
    System.out.println("normal flow...");  
  }  
}  