package com.example.example.intermediateoperations;

import java.util.stream.IntStream;

/** asLongStream widens each int value into a long value. */
public class IntermediateOperation23AsLongStream {
    public static void main(String[] args) {
        long total = IntStream.of(10, 20, 30)
                .asLongStream()
                .sum();

        System.out.println("Long total: " + total);
    }
}
