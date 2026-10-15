package com.example.intermediateoperations;

import java.util.List;

/** Easy: mapToInt produces an IntStream; sum is its terminal operation. */
public class IntermediatePractice03PrimitiveMapping {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Streams", "API");
        int totalCharacters = words.stream().mapToInt(String::length).sum();
        System.out.println("Total characters: " + totalCharacters);
    }
}