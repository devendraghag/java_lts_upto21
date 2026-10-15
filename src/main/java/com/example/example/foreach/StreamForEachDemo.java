package com.example.foreach;

import java.util.List;

/** Demonstrates Stream.forEach and Stream.forEachOrdered. */
public class StreamForEachDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ravi", "Mina", "Omar");

        System.out.println("Sequential stream with forEach:");
        names.stream().forEach(System.out::println);

        System.out.println("Parallel stream with forEachOrdered:");
        names.parallelStream().forEachOrdered(System.out::println);
    }
}
