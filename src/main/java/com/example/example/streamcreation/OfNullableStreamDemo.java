package com.example.streamcreation;

import java.util.stream.Stream;

/** Demonstrates Stream.ofNullable with null and non-null values. */
public class OfNullableStreamDemo {
    public static void main(String[] args) {
        String possiblyMissing = null;
        System.out.println("Elements produced for null: "
                + Stream.ofNullable(possiblyMissing).count());

        Stream.ofNullable("available")
                .forEach(value -> System.out.println("Value: " + value));

        System.out.println("Non-null values after flattening:");
        Stream.of("first", null, "third")
                .flatMap(Stream::ofNullable)
                .forEach(System.out::println);
    }
}
