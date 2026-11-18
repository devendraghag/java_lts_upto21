package com.example.example.terminaloperations;

import java.util.List;

/** average returns an OptionalDouble because an empty stream has no average. */
public class TerminalOperation09Average {
    public static void main(String[] args) {
        double average = List.of(10, 20, 30).stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);
    }
}
