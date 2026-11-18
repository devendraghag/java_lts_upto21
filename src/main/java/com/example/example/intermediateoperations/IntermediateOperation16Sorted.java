package com.example.example.intermediateoperations;

import java.util.Comparator;
import java.util.List;

/** sorted orders values naturally or with a supplied Comparator. */
public class IntermediateOperation16Sorted {
    public static void main(String[] args) {
        List<String> names = List.of("Ravi", "Asha", "Mina");

        List<String> ascending = names.stream().sorted().toList();
        List<String> longestFirst = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        System.out.println("Natural order: " + ascending);
        System.out.println("Longest first: " + longestFirst);
    }
}
