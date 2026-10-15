package com.example.streams;

import java.util.Iterator;
import java.util.stream.Stream;

/** Demonstrates stream traversal, close handlers, and the one-use rule. */
public class Stream06LifecycleDemo {
    public static void main(String[] args) {
        try (Stream<String> stream = Stream.of("north", "south", "east")
                .onClose(() -> System.out.println("Stream closed"))) {
            Iterator<String> iterator = stream.iterator();
            while (iterator.hasNext()) {
                System.out.println("Iterator value: " + iterator.next());
            }
        }

        // A stream can be consumed only once. Create a new stream for each pipeline.
        long count = Stream.of("one", "two", "three").count();
        System.out.println("Fresh stream count: " + count);
    }
}
