package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Exception Propagation2 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class TestExceptionPropagation2{
  void m(){
   // throw new java.io.IOException("device error");//checked exception
  }
  void n(){  
    m();  
  }  
  void p(){  
   try{  
    n();  
   }catch(Exception e){System.out.println("exception handeled");}  
  }  
  public static void main(String args[]){  
   TestExceptionPropagation2 obj=new TestExceptionPropagation2();  
   obj.p();  
   System.out.println("normal flow");  
  }  
}

//java: unreported exception java.io.IOException; must be caught or declared to be thrown