package com.example.example.intermediateoperations;

import java.util.List;

/** mapMulti emits zero or more ordinary values for each input value. */
public class IntermediateOperation12MapMulti {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        List<String> labels = numbers.stream()
                .<String>mapMulti((number, output) -> {
                    output.accept("number=" + number);
                    if (number % 2 == 0) {
                        output.accept("even=" + number);
                    }
                })
                .toList();

        System.out.println("Emitted values: " + labels);
    }
}
