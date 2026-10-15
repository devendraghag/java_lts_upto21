package com.example.streams;

import java.util.List;

/** Introduces the basic stream pipeline: source, intermediate steps, and terminal step. */
public class Stream02BasicPipelineDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ben", "Cara", "Dev");

        // A stream pipeline has:
        // 1. A source: names.stream()
        // 2. Intermediate operations: filter() and map()
        // 3. A terminal operation: forEach(), which starts processing.
        names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}