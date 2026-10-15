package com.example.streams;

import java.util.List;
import java.util.stream.IntStream;

/** Demonstrates parallel streams and deterministic result collection. */
public class Stream18ParallelStreamsDemo {
    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .sum();
        System.out.println("Parallel sum: " + total);

        List<String> values = List.of("alpha", "beta", "gamma", "delta");
        System.out.println("Parallel mode? " + values.parallelStream().isParallel());
        System.out.println("Sequential mode? " + values.parallelStream().sequential().isParallel());

        // forEach may run in any order; forEachOrdered preserves encounter order.
        values.parallelStream()
                .map(String::toUpperCase)
                .forEachOrdered(System.out::println);
    }
}
