package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


// class representing custom exception
/**
 * Easy: Demonstrates Test Custom Exception2 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class MyCustomException extends Exception  
{  
    
}  
    
// class that uses custom exception MyCustomException  
public class TestCustomException2  
{  
    // main method  
    public static void main(String args[])  
    {  
        try  
        {  
            // throw an object of user defined exception  
            throw new MyCustomException();  
        }  
        catch (MyCustomException ex)  
        {  
            System.out.println("Caught the exception");  
            System.out.println(ex.getMessage());  
        }  
  
        System.out.println("rest of the code...");    
    }  
}  