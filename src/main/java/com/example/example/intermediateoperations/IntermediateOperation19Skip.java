package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.IntStream;

/** skip discards the first n elements. */
public class IntermediateOperation19Skip {
    public static void main(String[] args) {
        List<Integer> afterFirstThree = IntStream.rangeClosed(1, 7)
                .skip(3)
                .boxed()
                .toList();

        System.out.println("After skipping three: " + afterFirstThree);
    }
}
