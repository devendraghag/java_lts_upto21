package com.example.example.intermediateoperations;

import java.util.List;

/** map transforms each element into one new element. */
public class IntermediateOperation03Map {
    public static void main(String[] args) {
        List<String> names = List.of("ava", "ben", "cara");

        List<String> capitalizedNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Capitalized names: " + capitalizedNames);
    }
}
