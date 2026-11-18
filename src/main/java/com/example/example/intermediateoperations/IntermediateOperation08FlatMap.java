package com.example.example.intermediateoperations;

import java.util.List;

/** flatMap turns each element into a stream, then combines those streams. */
public class IntermediateOperation08FlatMap {
    public static void main(String[] args) {
        List<List<String>> groups = List.of(
                List.of("A", "B"),
                List.of("C"),
                List.of("D", "E"));

        List<String> allLetters = groups.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Combined values: " + allLetters);
    }
}
