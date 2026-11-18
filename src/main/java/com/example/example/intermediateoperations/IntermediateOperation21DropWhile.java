package com.example.example.intermediateoperations;

import java.util.List;

/** dropWhile discards matching values from the start, then keeps the rest. */
public class IntermediateOperation21DropWhile {
    public static void main(String[] args) {
        List<Integer> values = List.of(2, 4, 6, 7, 8, 10);

        List<Integer> afterLeadingEvens = values.stream()
                .dropWhile(number -> number % 2 == 0)
                .toList();

        System.out.println("Values after leading evens: " + afterLeadingEvens);
    }
}
