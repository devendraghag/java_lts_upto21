package com.example.example.terminaloperations;

import java.util.Iterator;
import java.util.stream.Stream;

/** iterator lets you pull stream elements one at a time. */
public class TerminalOperation18Iterator {
    public static void main(String[] args) {
        Iterator<String> iterator = Stream.of("Java", "Stream", "Iterator").iterator();

        while (iterator.hasNext()) {
            System.out.println("Next value: " + iterator.next());
        }
    }
}
