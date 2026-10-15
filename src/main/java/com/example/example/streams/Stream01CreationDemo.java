package com.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** Demonstrates several ways to create a Stream. */
public class Stream01CreationDemo {
    public static void main(String[] args) {
        List<String> source = List.of("red", "green", "blue");
        System.out.println("From collection: " + source.stream().toList());
        System.out.println("From values: " + Stream.of("one", "two").toList());
        System.out.println("From array: " + Arrays.stream(new int[]{2, 4, 6}).boxed().toList());
        System.out.println("Nullable value: " + Stream.ofNullable("present").toList());

        Stream.Builder<String> builder = Stream.builder();
        builder.add("builder").add("stream");
        System.out.println("From builder: " + builder.build().toList());

        System.out.println("Iterate with a stopping predicate: "
                + Stream.iterate(1, number -> number <= 5, number -> number + 1).toList());
        System.out.println("Generate a fixed number: "
                + Stream.generate(() -> "tick").limit(3).toList());
        System.out.println("Concatenate streams: "
                + Stream.concat(Stream.of("A", "B"), Stream.of("C")).toList());
    }
}
