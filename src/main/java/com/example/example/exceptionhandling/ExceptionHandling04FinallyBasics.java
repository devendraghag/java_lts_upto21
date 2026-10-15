package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** EASY 4/17: Observe finally after both normal and exceptional try flow. */
public class ExceptionHandling04FinallyBasics {
    private static void normalPath() {
        try {
            System.out.println("Normal path: work completed");
        } finally {
            System.out.println("Normal path: finally ran");
        }
    }

    private static void exceptionalPath() {
        try {
            System.out.println("Exceptional path: about to divide by zero");
            int divisor = 0;
            int value = 5 / divisor;
            System.out.println(value);
        } catch (ArithmeticException exception) {
            System.out.println("Exceptional path: catch handled the error");
        } finally {
            System.out.println("Exceptional path: finally ran");
        }
    }

    public static void main(String[] args) {
        normalPath();
        exceptionalPath();
    }
}
