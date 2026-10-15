package com.example.collectors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Collectors02ToSet {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Streams", "Java");

        // toSet() removes duplicates; it does not promise iteration order.
        Set<String> result = words.stream().collect(Collectors.toSet());
        //I want a specific collection type

        System.out.println("unique count = " + result.size());
        System.out.println("contains Java = " + result.contains("Java"));
        System.out.println(words.getClass());
        System.out.println(result.getClass());
    }
}
