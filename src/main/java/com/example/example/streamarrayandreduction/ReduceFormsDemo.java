package com.example.streamarrayandreduction;

import java.util.List;
import java.util.Optional;

/** Demonstrates the three Stream.reduce overloads. */
public class ReduceFormsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 2, 9, 4);

        // One argument: a BinaryOperator; empty streams produce Optional.empty().
        Optional<Integer> sumOptional = numbers.stream().reduce(Integer::sum);
        System.out.println("One-argument reduce sum: " + sumOptional.orElseThrow());
        System.out.println("Empty stream result: "
                + List.<Integer>of().stream().reduce(Integer::sum));

        // Two arguments: identity and BinaryOperator.
        int sumWithIdentity = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Two-argument reduce sum: " + sumWithIdentity);

        // Three arguments: identity, accumulator, and combiner.
        // This form supports a result type different from the stream element type.
        List<String> words = List.of("Java", "streams", "reduce");
        int totalCharacters = words.parallelStream().reduce(
                0,
                (subtotal, word) -> subtotal + word.length(),
                Integer::sum);
        System.out.println("Three-argument reduce character count: " + totalCharacters);
    }
}
