package com.example.example.exceptionhandling;

/** HARD 27: trace catch and finally execution through nested try blocks. */
public class ExceptionHandling27NestedCatchFinallyOrder {
    public static void main(String[] args) {
        try {
            try {
                try {
                    throw new IllegalArgumentException("invalid input");
                } catch (IllegalArgumentException exception) {
                    System.out.println("Inner catch");
                    throw new IllegalStateException("inner layer failed", exception);
                } finally {
                    System.out.println("Inner finally");
                }
            } catch (IllegalStateException exception) {
                System.out.println("Outer catch; cause=" + exception.getCause().getMessage());
            } finally {
                System.out.println("Outer finally");
            }
        } finally {
            System.out.println("Method-level finally");
        }
    }
}
