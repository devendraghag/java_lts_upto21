package com.example.functionalinterfaces.predicateinterfaces;

import java.util.List;
import java.util.function.Predicate;

/** Pattern 5: pass a predicate into a reusable method. */
public class PredicatePattern05_PassAsArgument {
    public static void main(String[] args) {
        List<String> words = List.of("map", "collection", "set", "iterator");
        printMatching(words, word -> word.length() >= 5);
    }

    private static void printMatching(List<String> words, Predicate<String> condition) {
        words.stream().filter(condition).forEach(System.out::println);
    }
}