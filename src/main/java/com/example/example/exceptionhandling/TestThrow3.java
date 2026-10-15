package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


// class represents user-defined exception
/**
 * Easy: Demonstrates Test Throw3 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class UserDefinedException extends Exception  
{  
    public UserDefinedException(String str)  
    {  
        // Calling constructor of parent Exception  
        super(str);  
    }  
}  
// Class that uses above MyException  
public class TestThrow3  
{  
    public static void main(String args[])  
    {  
        try  
        {  
            // throw an object of user defined exception  
            throw new UserDefinedException("This is user-defined exception");  
        }  
        catch (UserDefinedException ude)  
        {  
            System.out.println("Caught the exception");  
            // Print the message from MyException object  
            System.out.println(ude.getMessage());  
        }  
    }  
}   