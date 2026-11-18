package com.example.example.intermediateoperations;

import java.util.List;
import java.util.stream.IntStream;

/** boxed converts primitive int values into Integer objects. */
public class IntermediateOperation22Boxed {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 4)
                .boxed()
                .toList();

        System.out.println("Integer objects: " + numbers);
    }
}
