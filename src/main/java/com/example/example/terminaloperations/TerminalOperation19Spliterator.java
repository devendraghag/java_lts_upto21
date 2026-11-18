package com.example.example.terminaloperations;

import java.util.Spliterator;
import java.util.stream.Stream;

/** spliterator traverses elements and can also split work into parts. */
public class TerminalOperation19Spliterator {
    public static void main(String[] args) {
        Spliterator<Integer> spliterator = Stream.of(10, 20, 30, 40).spliterator();

        System.out.println("Estimated size: " + spliterator.estimateSize());
        spliterator.tryAdvance(value -> System.out.println("First value: " + value));
        spliterator.forEachRemaining(value -> System.out.println("Remaining value: " + value));
    }
}
