package com.example.example.terminaloperations;

import java.util.List;

/** findFirst returns the first matching value in encounter order, if present. */
public class TerminalOperation14FindFirst {
    public static void main(String[] args) {
        int firstEven = List.of(5, 8, 10, 12).stream()
                .filter(number -> number % 2 == 0)
                .findFirst()
                .orElseThrow();

        System.out.println("First even number: " + firstEven);
    }
}
