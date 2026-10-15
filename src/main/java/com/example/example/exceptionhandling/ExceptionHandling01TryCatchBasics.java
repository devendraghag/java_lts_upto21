package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** EASY 1/17: Catch one exception and continue the program. */
public class ExceptionHandling01TryCatchBasics {
    public static void main(String[] args) {
        System.out.println("Before the risky operation");

        try {
            int divisor = args.length - args.length;
            int answer = 10 / divisor;
            System.out.println(answer); // This line is skipped after the exception.
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide an integer by zero.");
        }

        System.out.println("The program continues after the catch.");
    }
}
