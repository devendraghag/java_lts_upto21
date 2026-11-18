package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.DoubleStream;

/** flatMapToDouble combines DoubleStreams produced by each element. */
public class IntermediateOperation11FlatMapToDouble {
    public static void main(String[] args) {
        List<Double> bases = List.of(2.0, 5.0);

        double total = bases.stream()
                .flatMapToDouble(base -> DoubleStream.of(base, base * 10))
                .sum();

        System.out.println("Sum of expanded decimal values: " + total);
    }
}
