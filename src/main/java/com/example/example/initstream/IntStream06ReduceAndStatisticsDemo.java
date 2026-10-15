package com.example.initstream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/** Level 06: reduce values and collect primitive summary statistics. */
public class IntStream06ReduceAndStatisticsDemo {
    public static void main(String[] args) {
        int product = IntStream.rangeClosed(1, 5)
                .reduce(1, (left, right) -> left * right);
        System.out.println("Product from 1 to 5: " + product);

        IntSummaryStatistics stats = IntStream.of(4, 8, 15, 16, 23, 42)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Sum: " + stats.getSum());
    }
}
