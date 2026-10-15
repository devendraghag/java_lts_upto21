package com.example.terminaloperations;

import java.util.List;
import java.util.stream.Collector;

/** Advanced: Collector.of defines supplier, accumulator, combiner, and finisher. */
public class TerminalOperationPractice19CustomCollector {
    public static void main(String[] args) {
        Collector<String, StringBuilder, String> hyphenJoiner = Collector.of(
                StringBuilder::new,
                (builder, word) -> {
                    if (!builder.isEmpty()) {
                        builder.append(" - ");
                    }
                    builder.append(word);
                },
                (left, right) -> {
                    if (left.isEmpty()) return right;
                    if (right.isEmpty()) return left;
                    return left.append(" - ").append(right);
                },
                StringBuilder::toString);

        String result = List.of("Java", "Collectors", "Practice")
                .parallelStream()
                .collect(hyphenJoiner);

        System.out.println(result);
    }
}
