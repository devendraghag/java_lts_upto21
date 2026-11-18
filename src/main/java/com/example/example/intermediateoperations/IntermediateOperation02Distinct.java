package com.example.example.intermediateoperations;

import java.util.List;

/** distinct removes duplicate elements according to equals(). */
public class IntermediateOperation02Distinct {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 1, 2, 3, 1, 4);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}
