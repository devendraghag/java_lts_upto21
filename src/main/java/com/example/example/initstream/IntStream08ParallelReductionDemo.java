package com.example.initstream;

import java.util.stream.IntStream;

/** Level 08: compare sequential and parallel primitive reductions. */
public class IntStream08ParallelReductionDemo {
    public static void main(String[] args) {
        long sequentialSum = IntStream.rangeClosed(1, 1_000_000)
                .asLongStream()
                .sum();

        long parallelSum = IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .asLongStream()
                .sum();

        System.out.println("Sequential sum: " + sequentialSum);
        System.out.println("Parallel sum:   " + parallelSum);
        System.out.println("Results match:  " + (sequentialSum == parallelSum));
        // Parallel streams are not automatically faster; task size and overhead matter.
    }
}
