package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** MEDIUM 11/17: Recognize common runtime exceptions from common mistakes. */
public class ExceptionHandling11CommonRuntimeExceptions {
    private static void runExample(String label, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException exception) {
            System.out.println(label + " -> " + exception.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        runExample("Null reference", () -> {
            String name = null;
            name.length();
        });
        runExample("Bad array index", () -> {
            int[] values = { 1 };
            System.out.println(values[2]);
        });
        runExample("Bad number text", () -> Integer.parseInt("hello"));
        runExample("Integer division by zero", () -> {
            int divisor = 0;
            System.out.println(8 / divisor);
        });
    }
}
