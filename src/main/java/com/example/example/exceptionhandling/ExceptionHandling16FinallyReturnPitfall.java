package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** HARD 16/17: Avoid return from finally; it can replace a return or exception. */
public class ExceptionHandling16FinallyReturnPitfall {
    @SuppressWarnings("finally")
    private static int confusingReturn() {
        try {
            return 1;
        } finally {
            // Bad practice: this return replaces the try block's return value.
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("Returned value: " + confusingReturn()); // Prints 2.
        System.out.println("Do not return or throw from finally in normal code.");
    }
}
