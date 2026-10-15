package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors04ToUnmodifiableList {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 2, 4, 1);

        // This collector returns an unmodifiable List and preserves encounter order.
        List<Integer> result = values.stream()
                .collect(Collectors.toUnmodifiableList());

        System.out.println(result);
    }
}
