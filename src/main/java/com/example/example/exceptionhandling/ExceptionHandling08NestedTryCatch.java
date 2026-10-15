package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** MEDIUM 8/17: An inner catch handles one failure; an outer catch handles another. */
public class ExceptionHandling08NestedTryCatch {
    public static void main(String[] args) {
        try {
            try {
                int divisor = 0;
                int value = 20 / divisor;
                System.out.println(value);
            } catch (ArithmeticException exception) {
                System.out.println("Inner catch handled division by zero.");
            }

            int[] numbers = { 3, 6, 9 };
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Outer catch handled an invalid array index.");
        }

        System.out.println("Execution continues after both try blocks.");
    }
}
