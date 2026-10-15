package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors01ToList {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Streams", "Java");

        // Collectors.toList() collects all elements and preserves encounter order.
        // It does not promise a specific implementation or mutability.
        List<String> result = words.stream().collect(Collectors.toList());

        System.out.println(result);
    }
}
/*
We use collect() and Collectors in Java Streams when we want to take all stream results and combine/store them into one final result.*/
