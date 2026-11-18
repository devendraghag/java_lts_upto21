package com.example.example.terminaloperations;

import java.util.List;

/** toList returns the stream values as an unmodifiable List (Java 16+). */
public class TerminalOperation02ToList {
    public static void main(String[] args) {
        List<Integer> squares = List.of(1, 2, 3, 4).stream()
                .map(number -> number * number)
                .toList();

        System.out.println("Squares: " + squares);
        // squares.add(25); // UnsupportedOperationException: this List is unmodifiable.
    }
}
