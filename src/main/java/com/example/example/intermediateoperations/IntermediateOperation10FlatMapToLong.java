package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.LongStream;

/** flatMapToLong combines LongStreams produced by each element. */
public class IntermediateOperation10FlatMapToLong {
    public static void main(String[] args) {
        List<Integer> starts = List.of(1, 10);

        long total = starts.stream()
                .flatMapToLong(start -> LongStream.range(start, start + 3L))
                .sum();

        System.out.println("Sum of expanded long values: " + total);
    }
}
