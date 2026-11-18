package com.example.example.terminaloperations;

import java.util.List;

/** sum adds the values in a primitive numeric stream. */
public class TerminalOperation08Sum {
    public static void main(String[] args) {
        int total = List.of(10, 20, 30).stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total: " + total);
    }
}
