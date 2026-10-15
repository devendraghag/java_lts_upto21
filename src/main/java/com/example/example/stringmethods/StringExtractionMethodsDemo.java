package com.example.stringmethods;

import java.util.Arrays;

/** Demonstrates extracting and splitting String content. */
public class StringExtractionMethodsDemo {
    public static void main(String[] args) {
        String text = "red,green,,blue";

        System.out.println("substring: " + text.substring(4, 9));
        System.out.println("subSequence: " + text.subSequence(0, 3));
        System.out.println("split preserving trailing empty fields: "
                + Arrays.toString(text.split(",", -1)));

        String lines = "first line\nsecond line\n";
        lines.lines().forEach(System.out::println); // Added in Java 11.
    }
}
