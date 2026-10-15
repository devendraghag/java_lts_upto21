package com.example.streams;

import java.util.List;

/** Demonstrates common intermediate operations, including additions from Java 9+. */
public class Stream03IntermediateOperationsDemo {
    public static void main(String[] args) {
        List<String> words = List.of("pear", "apple", "fig", "apple", "plum", "watermelon");

        List<String> result = words.stream()
                .filter(word -> word.length() >= 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .skip(1)
                .limit(3)
                .toList();
        System.out.println("filter/map/distinct/sorted/skip/limit: " + result);

        List<Integer> firstThreeShortLengths = words.stream()
                .map(String::length)
                .takeWhile(length -> length <= 5)
                .toList();
        System.out.println("takeWhile: " + firstThreeShortLengths);

        List<Integer> afterShortLengths = words.stream()
                .map(String::length)
                .dropWhile(length -> length <= 5)
                .toList();
        System.out.println("dropWhile: " + afterShortLengths);

        // peek is mainly useful for observing a pipeline while debugging.
        long count = words.stream()
                .peek(word -> System.out.println("Processing: " + word))
                .filter(word -> word.startsWith("p"))
                .count();
        System.out.println("Words beginning with p: " + count);
    }
}
