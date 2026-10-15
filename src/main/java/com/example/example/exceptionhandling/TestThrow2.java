package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


import java.io.*;
  
/**
 * Easy: Demonstrates Test Throw2 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class TestThrow2 {   
  
    //function to check if person is eligible to vote or not   
    public static void method() throws FileNotFoundException {  
  
        FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");  
        BufferedReader fileInput = new BufferedReader(file);  
  
      
        throw new FileNotFoundException();  
      
    }  
    //main method  
    public static void main(String args[]){  
        try  
        {  
            method();  
        }   
        catch (FileNotFoundException e)   
        {  
            e.printStackTrace();  
        }  
        System.out.println("rest of the code...");    
  }    
}   