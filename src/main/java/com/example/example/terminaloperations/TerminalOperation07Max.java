package com.example.example.terminaloperations;

import java.util.List;

/** max returns the largest value according to the supplied Comparator. */
public class TerminalOperation07Max {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 3, 12, 5);

        int largest = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();

        System.out.println("Largest number: " + largest);
    }
}
