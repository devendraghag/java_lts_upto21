package com.example.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/** Demonstrates IntStream, LongStream, and primitive stream conversions. */
public class Stream13PrimitiveStreamsDemo {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 5).sum();
        System.out.println("Sum 1..5: " + sum);

        IntSummaryStatistics statistics = IntStream.of(4, 8, 15, 16, 23, 42)
                .summaryStatistics();
        System.out.println("Int summary: " + statistics);

        double average = IntStream.range(1, 6).average().orElse(0.0);
        System.out.println("Average 1..5: " + average);

        long total = LongStream.of(1_000_000_000L, 2_000_000_000L).sum();
        System.out.println("Long total: " + total);

        System.out.println("Primitive to object: "
                + IntStream.rangeClosed(1, 3).mapToObj(number -> "item-" + number).toList());
        System.out.println("Object to primitive sum: "
                + java.util.stream.Stream.of("4", "5", "6").mapToInt(Integer::parseInt).sum());
    }
}
