package com.example.example.helloworldways;

import java.util.stream.Stream;

/** Java 8: creates and prints the greeting through a small stream pipeline. */
public class HelloWorld13StreamPipeline {
    public static void main(String[] args) {
        Stream.of("Hello", "World")
                .reduce((first, second) -> first + ", " + second + "!")
                .ifPresent(System.out::println);
    }
}
