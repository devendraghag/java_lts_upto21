package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.io.IOException;

/** HARD 17/17: Compare checked exceptions, unchecked exceptions, and Errors. */
public class ExceptionHandling17ThrowableHierarchy {
    public static void main(String[] args) {
        Throwable[] examples = {
                new IOException("checked exception"),
                new IllegalArgumentException("unchecked exception"),
                new AssertionError("Error example")
        };

        for (Throwable problem : examples) {
            String category;
            if (problem instanceof Error) {
                category = "Error (unchecked)";
            } else if (problem instanceof RuntimeException) {
                category = "RuntimeException (unchecked)";
            } else {
                category = "checked exception";
            }
            System.out.println(problem.getClass().getSimpleName() + " -> " + category);
        }

        System.out.println("Errors are serious JVM or system problems; applications "
                + "usually should not catch them as routine failures.");
    }
}
