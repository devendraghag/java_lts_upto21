package com.example.example.intermediateoperations;

import java.util.List;

/** sequential requests sequential processing for the rest of the pipeline. */
public class IntermediateOperation25Sequential {
    public static void main(String[] args) {
        List<Integer> result = List.of(1, 2, 3, 4)
                .parallelStream()
                .sequential()
                .map(number -> number * 10)
                .toList();

        System.out.println("Sequentially processed result: " + result);
    }
}
