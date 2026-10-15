package com.example.generics;

import java.util.List;

/** Demonstrates recursive bounds and type erasure. */
public class RecursiveBoundsAndErasureDemo {
    private static <T extends Comparable<? super T>> T maximum(List<? extends T> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty");
        }

        T currentMaximum = values.get(0);
        for (T value : values) {
            if (value.compareTo(currentMaximum) > 0) {
                currentMaximum = value;
            }
        }
        return currentMaximum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum: " + maximum(List.of(4, 9, 2)));

        List<String> strings = List.of("a");
        List<Integer> integers = List.of(1);
        System.out.println("Same runtime class after erasure: "
                + (strings.getClass() == integers.getClass()));
    }
}
