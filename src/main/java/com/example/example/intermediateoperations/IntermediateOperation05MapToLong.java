package com.example.example.intermediateoperations;

import java.util.List;

/** mapToLong transforms objects into primitive long values (a LongStream). */
public class IntermediateOperation05MapToLong {
    public static void main(String[] args) {
        List<Integer> itemCounts = List.of(3, 5, 8);

        long totalItems = itemCounts.stream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println("Total items: " + totalItems);
    }
}
