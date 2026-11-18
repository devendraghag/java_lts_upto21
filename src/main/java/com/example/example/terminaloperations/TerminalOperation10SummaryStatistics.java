package com.example.example.terminaloperations;

import java.util.IntSummaryStatistics;
import java.util.List;

/** summaryStatistics calculates count, sum, min, average, and max together. */
public class TerminalOperation10SummaryStatistics {
    public static void main(String[] args) {
        IntSummaryStatistics statistics = List.of(4, 7, 2, 9).stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Max: " + statistics.getMax());
    }
}
