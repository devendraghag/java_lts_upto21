package com.example.example.intermediateoperations;

import java.util.List;

/** mapMultiToDouble emits zero or more primitive double values per input. */
public class IntermediateOperation15MapMultiToDouble {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        double average = numbers.stream()
                .mapMultiToDouble((number, output) -> {
                    output.accept(number);
                    output.accept(number + 0.5);
                })
                .average()
                .orElse(0.0);

        System.out.println("Average of emitted decimals: " + average);
    }
}
