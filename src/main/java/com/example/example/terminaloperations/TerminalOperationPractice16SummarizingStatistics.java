package com.example.terminaloperations;

import java.util.List;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/** Harder: summarizingInt collects count, sum, min, average, and max in one result object. */
public class TerminalOperationPractice16SummarizingStatistics {
    record Task(String title, int minutes) {
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Read", 20),
                new Task("Code", 65),
                new Task("Review", 35));

        IntSummaryStatistics stats = tasks.stream()
                .collect(Collectors.summarizingInt(Task::minutes));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Total minutes: " + stats.getSum());
        System.out.println("Average minutes: " + stats.getAverage());
        System.out.println("Shortest / longest: " + stats.getMin() + " / " + stats.getMax());
    }
}
