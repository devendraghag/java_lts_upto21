package com.example.example.intermediateoperations;

import java.util.List;

/** takeWhile keeps values from the start until the first non-match. */
public class IntermediateOperation20TakeWhile {
    public static void main(String[] args) {
        List<Integer> values = List.of(2, 4, 6, 7, 8, 10);

        List<Integer> leadingEvens = values.stream()
                .takeWhile(number -> number % 2 == 0)
                .toList();

        System.out.println("Leading even values: " + leadingEvens);
    }
}
