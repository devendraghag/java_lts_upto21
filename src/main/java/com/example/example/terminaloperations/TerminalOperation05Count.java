package com.example.example.terminaloperations;

import java.util.List;

/** count returns the number of elements in the stream. */
public class TerminalOperation05Count {
    public static void main(String[] args) {
        long longNames = List.of("Al", "Beatrice", "Cy", "Diana").stream()
                .filter(name -> name.length() > 3)
                .count();

        System.out.println("Names longer than three letters: " + longNames);
    }
}
