package com.example.intermediateoperations;

import java.util.List;
import java.util.Optional;

/** Harder: Optional.stream lets flatMap keep present values and omit empty values. */
public class IntermediatePractice12OptionalFlatMap {
    public static void main(String[] args) {
        List<Optional<String>> values = List.of(Optional.of("Java"), Optional.empty(), Optional.of("Streams"));
        List<String> result = values.stream().flatMap(Optional::stream).map(String::toUpperCase).toList();
        System.out.println(result);
    }
}