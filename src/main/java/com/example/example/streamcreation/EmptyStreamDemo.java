package com.example.streamcreation;

import java.util.stream.Stream;

/** Demonstrates creating and safely using an empty stream. */
public class EmptyStreamDemo {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();

        System.out.println("Element count: " + empty.count());

        // A stream can be consumed only once, so create another empty stream.
        boolean hasAnyElement = Stream.<String>empty().findAny().isPresent();
        System.out.println("Has an element: " + hasAnyElement);
    }
}
