package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors10Reducing {
    public static void main(String[] args) {
        List<Integer> values = List.of(2, 3, 4);

        // reducing(identity, accumulator) folds values into one result.
        int product = values.stream()
                .collect(Collectors.reducing(1, (left, right) -> left * right));

        System.out.println("product = " + product);
    }
}
