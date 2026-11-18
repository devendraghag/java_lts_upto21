package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.IntStream;

/** mapToObj transforms primitive int values into ordinary objects. */
public class IntermediateOperation07MapToObj {
    public static void main(String[] args) {
        List<String> labels = IntStream.rangeClosed(1, 3)
                .mapToObj(number -> "Item-" + number)
                .toList();

        System.out.println("Labels: " + labels);
    }
}
