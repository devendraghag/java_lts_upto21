package com.example.stringmethods;

/** Demonstrates transformations and the immutability of String. */
public class StringTransformationMethodsDemo {
    public static void main(String[] args) {
        String original = "  Java 21  ";
        String stripped = original.strip(); // Unicode-aware whitespace removal; Java 11+.

        System.out.println("Original: '" + original + "'");
        System.out.println("strip: '" + stripped + "'");
        System.out.println("trim: '" + original.trim() + "'");
        System.out.println("replace: " + stripped.replace("21", "SE"));
        System.out.println("replaceAll regex: " + "a1b2c3".replaceAll("\\d", "-"));
        System.out.println("repeat: " + "ha".repeat(3)); // Added in Java 11.
        System.out.println("Original remains: '" + original + "'");
    }
}
