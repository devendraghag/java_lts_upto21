package com.example.intermediateoperations;

import java.util.List;

/** Medium+: takeWhile and dropWhile operate on the matching prefix of an ordered stream. */
public class IntermediatePractice10TakeWhileDropWhile {
    public static void main(String[] args) {
        List<Integer> values = List.of(2, 4, 6, 7, 8, 10);
        System.out.println("Even prefix: " + values.stream().takeWhile(n -> n % 2 == 0).toList());
        System.out.println("After prefix: " + values.stream().dropWhile(n -> n % 2 == 0).toList());
    }
}