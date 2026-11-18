package com.example.example.intermediateoperations;

import java.util.List;

/** mapMultiToInt emits zero or more primitive int values per input. */
public class IntermediateOperation13MapMultiToInt {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        int sum = numbers.stream()
                .mapMultiToInt((number, output) -> {
                    output.accept(number);
                    output.accept(number * 10);
                })
                .sum();

        System.out.println("Sum of emitted ints: " + sum);
    }
}
