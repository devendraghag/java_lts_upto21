package com.example.terminaloperations;

import java.util.List;
import java.util.stream.Collectors;

/** Advanced: teeing sends each element to two collectors and combines their final results. */
public class TerminalOperationPractice18Teeing {
    record ScoreSummary(long count, int total) {
    }

    public static void main(String[] args) {
        List<Integer> scores = List.of(80, 95, 72, 88);

        ScoreSummary summary = scores.stream().collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.summingInt(Integer::intValue),
                ScoreSummary::new));

        System.out.println("Scores: " + summary.count());
        System.out.println("Total: " + summary.total());
    }
}
