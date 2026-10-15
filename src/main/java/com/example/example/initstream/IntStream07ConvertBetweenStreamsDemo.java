package com.example.initstream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Level 07: move between object streams, IntStream, arrays, and boxed lists. */
public class IntStream07ConvertBetweenStreamsDemo {
    public static void main(String[] args) {
        // mapToInt avoids wrapping each primitive int in an Integer during processing.
        int totalCharacters = Stream.of("Java", "Stream", "API")
                .mapToInt(String::length)
                .sum();
        System.out.println("Total characters: " + totalCharacters);

        int[] primitiveArray = IntStream.rangeClosed(1, 4).toArray();
        System.out.println("Array length: " + primitiveArray.length);

        // A List stores Integer objects, so box() converts the primitive values.
        List<Integer> boxedValues = IntStream.of(2, 4, 6).boxed().toList();
        System.out.println("Boxed list: " + boxedValues);
    }
}
