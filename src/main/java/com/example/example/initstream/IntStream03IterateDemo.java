package com.example.initstream;

import java.util.stream.IntStream;

/** Level 03: generate a sequence by repeatedly applying a rule to the previous value. */
public class IntStream03IterateDemo {
    public static void main(String[] args) {
        // Start at 1, then add 2 each time. limit keeps this infinite stream finite.
        IntStream.iterate(1, number -> number + 2)
                .limit(6)
                .forEach(System.out::println); // 1, 3, 5, 7, 9, 11
    }
}
