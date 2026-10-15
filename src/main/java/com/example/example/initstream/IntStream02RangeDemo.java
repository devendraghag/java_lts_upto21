package com.example.initstream;

import java.util.stream.IntStream;

/** Level 02: create consecutive integers with range and rangeClosed. */
public class IntStream02RangeDemo {
    public static void main(String[] args) {
        System.out.println("range(1, 5) excludes 5:");
        IntStream.range(1, 5).forEach(System.out::println); // 1, 2, 3, 4

        System.out.println("rangeClosed(1, 5) includes 5:");
        IntStream.rangeClosed(1, 5).forEach(System.out::println); // 1, 2, 3, 4, 5
    }
}
