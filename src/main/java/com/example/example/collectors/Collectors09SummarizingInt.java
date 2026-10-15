package com.example.collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors09SummarizingInt {
    public static void main(String[] args) {
        List<Integer> scores = List.of(70, 85, 95);

        IntSummaryStatistics statistics = scores.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(statistics);
        System.out.println("count = " + statistics.getCount());
        System.out.println("min = " + statistics.getMin());
        System.out.println("max = " + statistics.getMax());
        System.out.println("sum = " + statistics.getSum());
        System.out.println("average = " + statistics.getAverage());
    }
}
