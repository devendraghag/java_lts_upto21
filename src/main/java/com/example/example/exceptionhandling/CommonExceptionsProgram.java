package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Easy: Demonstrates Common Exceptions Program in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class CommonExceptionsProgram {
    private static void demonstrate(String name, Runnable operation) {
        try {
            operation.run();
        } catch (RuntimeException exception) {
            System.out.println(name + " -> " + exception.getClass().getName());
        }
    }

    public static void main(String[] args) {
        demonstrate("null", new Runnable() {
            public void run() { String value = null; value.length(); }
        });
        demonstrate("arithmetic", new Runnable() {
            public void run() { int zero = 0; System.out.println(10 / zero); }
        });
        demonstrate("array", new Runnable() {
            public void run() { System.out.println(new int[1][2]); }
        });
        demonstrate("cast", new Runnable() {
            public void run() { Object value = new Integer(1); System.out.println((String) value); }
        });
        demonstrate("number", new Runnable() {
            public void run() { Integer.parseInt("not-a-number"); }
        });
        demonstrate("argument", new Runnable() {
            public void run() { throw new IllegalArgumentException("invalid"); }
        });
    }
}
