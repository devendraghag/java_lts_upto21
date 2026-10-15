package com.example.initstream;

import java.util.stream.IntStream;

/** Level 01: create a small IntStream from explicit integer values. */
public class IntStream01OfValuesDemo {
    public static void main(String[] args) {
        // IntStream is a stream specialized for primitive int values.
        IntStream.of(10, 20, 30).forEach(System.out::println);
    }
}
