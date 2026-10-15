package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Nested Try Block2 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class NestedTryBlock2 {
     
    public static void main(String args[])  
    {  
        // outer (main) try block  
        try {  
    
            //inner try block 1   
            try {  
    
                // inner try block 2  
                try {  
                    int arr[] = { 1, 2, 3, 4 };  
  
                    //printing the array element out of its bounds  
                    System.out.println(arr[10]);  
                }  
    
                // to handles ArithmeticException  
                catch (ArithmeticException e) {  
                    System.out.println("Arithmetic exception");  
                    System.out.println(" inner try block 2");  
                }  
            }  
    
            // to handle ArithmeticException   
            catch (ArithmeticException e) {  
                System.out.println("Arithmetic exception");  
                System.out.println("inner try block 1");  
            }  
        }  
    
        // to handle ArrayIndexOutOfBoundsException   
        catch (ArrayIndexOutOfBoundsException e4) {  
            System.out.print(e4);  
            System.out.println(" outer (main) try block");  
        }  
        catch (Exception e5) {  
            System.out.print("Exception");  
            System.out.println(" handled in main try-block");  
        }  
    }  
}  