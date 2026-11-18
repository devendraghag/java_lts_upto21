package com.example.example.intermediateoperations;

import java.util.List;

/** filter keeps only the elements that match a condition. */
public class IntermediateOperation01Filter {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println("Even numbers: " + evenNumbers);
    }
}
