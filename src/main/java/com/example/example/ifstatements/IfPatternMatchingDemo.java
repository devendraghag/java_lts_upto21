package com.example.ifstatements;

/** Demonstrates pattern matching for instanceof in an if statement (Java 16+). */
public class IfPatternMatchingDemo {
    public static void main(String[] args) {
        Object value = "Java 21";

        if (value instanceof String text && !text.isBlank()) {
            // The pattern variable text is available after a successful match.
            System.out.println("String length: " + text.length());
        } else {
            System.out.println("Value is not a non-blank String.");
        }
    }
}
