package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


import java.io.*;
/**
 * Easy: Demonstrates Testthrows4 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class M2{
 void method()throws IOException{  
  throw new IOException("device error");  
 }  
}  
class Testthrows4{  
   public static void main(String args[])throws IOException{//declare exception  
     M2 m=new M2();
     m.method();  
  
    System.out.println("normal flow...");  
  }  
}  