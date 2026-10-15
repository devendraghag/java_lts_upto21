package com.example.terminaloperations;

import java.util.List;

/** Medium: Stream.toList() is a terminal operation that returns an unmodifiable List. */
public class TerminalOperationPractice10ToList {
    public static void main(String[] args) {
        List<String> source = List.of("java", "streams", "jdk");
        List<String> result = source.stream().map(String::toUpperCase).toList();

        System.out.println("Result: " + result);
        System.out.println("Source is unchanged: " + source);
        // result.add("EXTRA"); // Throws UnsupportedOperationException.
    }
}
