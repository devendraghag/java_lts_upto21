package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Exception Propagation1 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class TestExceptionPropagation1{
  void m(){  
    int data=50/0;  
  }  
  void n(){  
    m();  
  }  
  void p(){  
   try{  
    n();  
   }catch(Exception e){System.out.println("exception handled");}  
  }  
  public static void main(String args[]){  
   TestExceptionPropagation1 obj=new TestExceptionPropagation1();  
   obj.p();  
   System.out.println("normal flow...");  
  }  
}  