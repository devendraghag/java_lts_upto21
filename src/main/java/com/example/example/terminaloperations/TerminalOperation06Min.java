package com.example.example.terminaloperations;

import java.util.List;

/** min returns the smallest value according to the supplied Comparator. */
public class TerminalOperation06Min {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 3, 12, 5);

        int smallest = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();

        System.out.println("Smallest number: " + smallest);
    }
}
