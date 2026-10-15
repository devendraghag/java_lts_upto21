package com.example.stringmethods;

/** Demonstrates basic String inspection methods. */
public class StringInspectionMethodsDemo {
    public static void main(String[] args) {
        String text = "Java 21";

        System.out.println("length: " + text.length());
        System.out.println("isEmpty: " + text.isEmpty());
        System.out.println("isBlank: " + "   ".isBlank()); // Added in Java 11.
        System.out.println("charAt(0): " + text.charAt(0));
        System.out.println("codePointAt(5): " + text.codePointAt(5));
    }
}
