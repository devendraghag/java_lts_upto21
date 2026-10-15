package com.example.terminaloperations;

import java.util.List;
import java.util.stream.Collectors;

/** Medium: Collectors.joining has delimiter, prefix, and suffix options. */
public class TerminalOperationPractice12Joining {
    public static void main(String[] args) {
        List<String> tags = List.of("java", "streams", "jdk21");

        String joined = tags.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" | ", "[", "]"));

        System.out.println(joined);
    }
}
