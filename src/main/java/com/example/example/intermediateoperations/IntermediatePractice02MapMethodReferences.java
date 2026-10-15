package com.example.intermediateoperations;

import java.util.List;
import java.util.function.Function;

/** Easy: map transforms each value; String instance methods supply Function references. */
public class IntermediatePractice02MapMethodReferences {
    public static void main(String[] args) {
        List<String> words = List.of("  java ", " streams  ", "  jdk21");
        Function<String, String> lambda = word -> word.trim().toUpperCase();

        System.out.println(words.stream().map(lambda).toList());
        System.out.println(words.stream().map(String::trim).map(String::toUpperCase).toList());
    }
}