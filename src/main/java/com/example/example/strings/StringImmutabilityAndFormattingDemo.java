package com.example.strings;

/** Immutability, formatted(), text blocks, and transform(). */
public class StringImmutabilityAndFormattingDemo {
    public static void main(String[] args) {
        String original = "hello";
        String changed = original.toUpperCase();
        System.out.println("Original remains: " + original);
        System.out.println("New value: " + changed);

        String summary = "Name: %s, score: %d".formatted("Asha", 95); // Java 15+
        System.out.println(summary);

        String report = """
                Student: Asha
                    Course: Java
                """;
        System.out.println(report.stripIndent()); // Text blocks and stripIndent are Java 15+.

        String normalized = "  Java  ".transform(String::strip).transform(String::toUpperCase); // Java 12+
        System.out.println("Transformed: " + normalized);

        StringBuilder repeatedWork = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            repeatedWork.append(i).append(": ").append("Hello").append(System.lineSeparator());
        }
        System.out.print(repeatedWork);
    }
}
