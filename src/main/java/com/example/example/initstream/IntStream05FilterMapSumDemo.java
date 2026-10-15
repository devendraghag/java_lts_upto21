package com.example.initstream;

import java.util.stream.IntStream;

/** Level 05: filter, transform, and calculate a result from primitive values. */
public class IntStream05FilterMapSumDemo {
    public static void main(String[] args) {
        int sumOfDoubledEvens = IntStream.rangeClosed(1, 10)
                .filter(number -> number % 2 == 0) // Keep only even numbers.
                .map(number -> number * 2)         // Double each remaining value.
                .sum();                            // IntStream has primitive reductions.

        System.out.println("Sum of doubled even numbers: " + sumOfDoubledEvens);
    }
}
