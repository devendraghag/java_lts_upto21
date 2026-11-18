package com.example.example.intermediateoperations;

import java.util.List;

/** flatMapToInt combines int streams produced by each element. */
public class IntermediateOperation09FlatMapToInt {
    public static void main(String[] args) {
        List<String> words = List.of("cat", "dog");

        int totalCharacters = words.stream()
                .flatMapToInt(String::chars)
                .sum();

        System.out.println("Sum of character codes: " + totalCharacters);
        System.out.println("Character count: " + words.stream()
                .flatMapToInt(String::chars)
                .count());
    }
}
