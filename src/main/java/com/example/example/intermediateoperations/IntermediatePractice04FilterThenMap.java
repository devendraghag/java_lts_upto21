package com.example.intermediateoperations;

import java.util.List;

/** Easy+: filter values, then transform the values that remain. */
public class IntermediatePractice04FilterThenMap {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Dev", "Ananya", "Mina", "Arun");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .toList();
        System.out.println(result);
    }
}