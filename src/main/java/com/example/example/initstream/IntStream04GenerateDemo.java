package com.example.initstream;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/** Level 04: create values from a supplier with generate and limit. */
public class IntStream04GenerateDemo {
    public static void main(String[] args) {
        AtomicInteger next = new AtomicInteger(1);

        // generate() has no natural end, so limit() is important here.
        IntStream.generate(next::getAndIncrement)
                .limit(5)
                .forEach(System.out::println); // 1, 2, 3, 4, 5
    }
}
