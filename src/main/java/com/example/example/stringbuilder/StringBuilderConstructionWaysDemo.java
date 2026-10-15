package com.example.stringbuilder;

import java.util.List;

/** Demonstrates building strings from pieces and appending values of different types. */
public class StringBuilderConstructionWaysDemo {
    public static void main(String[] args) {
        StringBuilder report = new StringBuilder();
        report.append("Student: ")
                .append("Asha")
                .append(", score: ")
                .append(95)
                .append(", passed: ")
                .append(true);
        System.out.println(report);

        List<String> words = List.of("Build", "strings", "efficiently");
        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            if (!sentence.isEmpty()) {
                sentence.append(' ');
            }
            sentence.append(word);
        }
        System.out.println(sentence);
    }
}
