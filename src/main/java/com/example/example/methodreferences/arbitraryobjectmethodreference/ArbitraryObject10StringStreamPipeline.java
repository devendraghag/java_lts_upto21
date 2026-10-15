package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.List;

/** Medium: method references stand in for one-argument lambdas in Stream stages. */
public class ArbitraryObject10StringStreamPipeline {
    public static void main(String[] args) {
        List<String> words = List.of(" Java ", " ", " Streams ");

        // Equivalent lambdas: s -> s.trim() and s -> s.isEmpty().
        List<String> result = words.stream()
                .map(String::trim)
                .filter(String::isEmpty)
                .toList();

        System.out.println(result);
    }
}
