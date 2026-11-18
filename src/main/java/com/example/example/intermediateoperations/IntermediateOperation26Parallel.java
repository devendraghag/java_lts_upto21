package com.example.example.intermediateoperations;

import java.util.List;

/** parallel requests parallel processing; execution order may differ. */
public class IntermediateOperation26Parallel {
    public static void main(String[] args) {
        List<Integer> result = List.of(1, 2, 3, 4)
                .stream()
                .parallel()
                .map(number -> number * 10)
                .toList();

        System.out.println("Result values: " + result);
        System.out.println("Parallel mode: " + List.of(1, 2, 3, 4).parallelStream().isParallel());
    }
}
