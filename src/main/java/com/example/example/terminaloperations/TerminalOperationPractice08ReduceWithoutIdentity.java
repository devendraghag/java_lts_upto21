package com.example.terminaloperations;

import java.util.List;
import java.util.Optional;

/** Medium: reduce(accumulator) has no identity, so its result is Optional<T>. */
public class TerminalOperationPractice08ReduceWithoutIdentity {
    public static void main(String[] args) {
        List<Integer> values = List.of(3, 4, 5);
        Optional<Integer> product = values.stream().reduce((left, right) -> left * right);
        Optional<Integer> empty = List.<Integer>of().stream().reduce(Integer::sum);

        System.out.println("Product: " + product.orElse(-1));
        System.out.println("Empty result: " + empty);
    }
}
