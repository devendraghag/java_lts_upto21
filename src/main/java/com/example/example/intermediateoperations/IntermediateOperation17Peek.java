package com.example.example.intermediateoperations;

import java.util.List;

/** peek is mainly for observing values while a pipeline runs. */
public class IntermediateOperation17Peek {
    public static void main(String[] args) {
        List<Integer> doubledEvens = List.of(1, 2, 3, 4).stream()
                .peek(number -> System.out.println("Before filter: " + number))
                .filter(number -> number % 2 == 0)
                .peek(number -> System.out.println("After filter: " + number))
                .map(number -> number * 2)
                .toList();

        System.out.println("Result: " + doubledEvens);
    }
}
