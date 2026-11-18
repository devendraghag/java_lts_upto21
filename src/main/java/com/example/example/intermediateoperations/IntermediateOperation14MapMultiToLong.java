package com.example.example.intermediateoperations;

import java.util.List;

/** mapMultiToLong emits zero or more primitive long values per input. */
public class IntermediateOperation14MapMultiToLong {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6);

        long sum = numbers.stream()
                .mapMultiToLong((number, output) -> {
                    output.accept(number.longValue());
                    output.accept(number * 100L);
                })
                .sum();

        System.out.println("Sum of emitted longs: " + sum);
    }
}