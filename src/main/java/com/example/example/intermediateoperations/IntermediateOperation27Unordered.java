package com.example.example.intermediateoperations;

import java.util.List;

/** unordered removes an encounter-order requirement when order is not needed. */
public class IntermediateOperation27Unordered {
    public static void main(String[] args) {
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .unordered()
                .filter(number -> number % 2 == 0)
                .toList();

        // This example's result may still look ordered; unordered does not shuffle it.
        System.out.println("Even values (order is not guaranteed): " + result);
    }
}
