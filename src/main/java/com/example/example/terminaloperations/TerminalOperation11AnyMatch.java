package com.example.example.terminaloperations;

import java.util.List;

/** anyMatch is true when at least one element matches the condition. */
public class TerminalOperation11AnyMatch {
    public static void main(String[] args) {
        boolean hasNegative = List.of(4, -2, 7).stream()
                .anyMatch(number -> number < 0);

        System.out.println("Has a negative number: " + hasNegative);
    }
}
