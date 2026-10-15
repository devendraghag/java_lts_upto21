package com.example.terminaloperations;

import java.util.List;

/** Medium: reduce(identity, accumulator) always has an identity result, including for empty input. */
public class TerminalOperationPractice07ReduceWithIdentity {
    public static void main(String[] args) {
        List<Integer> prices = List.of(12, 8, 25, 5);

        int sumWithLambda = prices.stream().reduce(0, (subtotal, price) -> subtotal + price);
        int sumWithMethodReference = prices.stream().reduce(0, Integer::sum);
        int emptySum = List.<Integer>of().stream().reduce(0, Integer::sum);

        System.out.println("Lambda sum: " + sumWithLambda);
        System.out.println("Method-reference sum: " + sumWithMethodReference);
        System.out.println("Empty sum with identity: " + emptySum);
    }
}
