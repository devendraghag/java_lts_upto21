package com.example.example.intermediateoperations;

import java.util.stream.IntStream;

/** asDoubleStream widens each int value into a double value. */
public class IntermediateOperation24AsDoubleStream {
    public static void main(String[] args) {
        double average = IntStream.of(10, 20, 30)
                .asDoubleStream()
                .average()
                .orElse(0.0);

        System.out.println("Double average: " + average);
    }
}
