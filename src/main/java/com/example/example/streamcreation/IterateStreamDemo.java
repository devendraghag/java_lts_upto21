package com.example.streamcreation;

import java.util.stream.Stream;

/** Demonstrates the two-argument, unbounded Stream.iterate overload. */
public class IterateStreamDemo {
    public static void main(String[] args) {
        Stream.iterate(1, number -> number + 1)
                .limit(10)
                .forEach(System.out::println);
    }
}
