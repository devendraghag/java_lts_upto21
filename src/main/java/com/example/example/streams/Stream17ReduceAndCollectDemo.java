package com.example.streams;

import java.util.List;

/** Demonstrates reduce overloads and the mutable three-argument collect operation. */
public class Stream17ReduceAndCollectDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4);

        int sumWithIdentity = numbers.stream().reduce(0, Integer::sum);
        System.out.println("reduce with identity: " + sumWithIdentity);

        int productWithAccumulatorAndCombiner = numbers.parallelStream()
                .reduce(1, (left, right) -> left * right, (left, right) -> left * right);
        System.out.println("parallel reduce with identity/accumulator/combiner: "
                + productWithAccumulatorAndCombiner);

        String joined = List.of("Java", "Stream", "API").stream()
                .collect(StringBuilder::new,
                        (builder, word) -> {
                            if (builder.length() > 0) {
                                builder.append(' ');
                            }
                            builder.append(word);
                        },
                        (left, right) -> {
                            if (left.length() > 0 && right.length() > 0) {
                                left.append(' ');
                            }
                            left.append(right);
                        })
                .toString();
        System.out.println("three-argument collect: " + joined);
    }
}
