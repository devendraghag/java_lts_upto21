package com.example.example.intermediateoperations;

import java.util.List;

/** mapToInt transforms objects into primitive int values (an IntStream). */
public class IntermediateOperation04MapToInt {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Stream", "API");

        int totalCharacters = words.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Total characters: " + totalCharacters);
    }
}
