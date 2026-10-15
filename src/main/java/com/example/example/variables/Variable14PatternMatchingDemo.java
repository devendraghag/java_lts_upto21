package com.example.variables;

/** Level 14: Demonstrates pattern variables from instanceof (Java 16+) and switch (Java 21). */
public class Variable14PatternMatchingDemo {
    private static String describe(Object value) {
        if (value instanceof String text && !text.isBlank()) {
            // text is in scope where the instanceof test guarantees a String.
            return "Text with " + text.length() + " characters";
        }

        return switch (value) {
            case Integer number -> "Integer value " + number;
            case String text -> "String value '" + text + "'";
            case null -> "null value";
            default -> "Other value";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe("Java 21"));
        System.out.println(describe(42));
        System.out.println(describe(null));
    }
}
