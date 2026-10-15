package com.example.optionalclass;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/** Demonstrates primitive Optional specializations. */
public class PrimitiveOptionalTypesDemo {
    public static void main(String[] args) {
        OptionalInt count = OptionalInt.of(5);
        OptionalLong distance = OptionalLong.empty();
        OptionalDouble average = OptionalDouble.of(87.5);

        System.out.println("Count: " + count.orElse(0));
        System.out.println("Distance present: " + distance.isPresent());
        average.ifPresent(value -> System.out.println("Average: " + value));

        int total = OptionalInt.of(4).stream().sum(); // Primitive stream API.
        System.out.println("Stream total: " + total);
    }
}
