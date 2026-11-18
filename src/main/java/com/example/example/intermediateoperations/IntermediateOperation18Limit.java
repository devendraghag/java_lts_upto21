package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.IntStream;

/** limit keeps at most the first n elements. */
public class IntermediateOperation18Limit {
    public static void main(String[] args) {
        List<Integer> firstFive = IntStream.iterate(1, number -> number + 1)
                .limit(5)
                .boxed()
                .toList();

        System.out.println("First five: " + firstFive);
    }
}
