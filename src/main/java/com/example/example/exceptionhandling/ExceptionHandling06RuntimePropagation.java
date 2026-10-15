package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** EASY 6/17: An unchecked exception travels up the call stack to a handler. */
public class ExceptionHandling06RuntimePropagation {
    private static void divide() {
        System.out.println("divide() starts");
        int divisor = 0;
        int answer = 12 / divisor;
        System.out.println(answer);
    }

    private static void calculate() {
        System.out.println("calculate() calls divide()");
        divide();
    }

    public static void main(String[] args) {
        try {
            calculate();
        } catch (ArithmeticException exception) {
            System.out.println("main caught: " + exception);
        }
        System.out.println("main continues");
    }
}
