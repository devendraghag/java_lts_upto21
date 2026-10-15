package com.example.intermediateoperations;

import java.util.stream.Stream;

/** Challenge: takeWhile gives an infinite generated stream a data-dependent stopping point. */
public class IntermediatePractice17IterateTakeWhile {
    public static void main(String[] args) {
        var powersOfTwo = Stream.iterate(1, value -> value * 2)
                .takeWhile(value -> value <= 100)
                .toList();
        System.out.println(powersOfTwo);
    }
}