package com.example.streams;

import java.util.List;
import java.util.Optional;

/** Demonstrates terminal operations that produce values or side effects. */
public class Stream05TerminalOperationsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 8, 12, 15, 20);

        System.out.println("forEach:");
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);

        System.out.println("count: " + numbers.stream().count());
        System.out.println("any even: " + numbers.stream().anyMatch(number -> number % 2 == 0));
        System.out.println("all positive: " + numbers.stream().allMatch(number -> number > 0));
        System.out.println("none negative: " + numbers.stream().noneMatch(number -> number < 0));

        Optional<Integer> firstOverTen = numbers.stream()
                .filter(number -> number > 10)
                .findFirst();
        System.out.println("findFirst: " + firstOverTen.orElse(-1));
        System.out.println("findAny: " + numbers.stream().filter(number -> number > 10).findAny());
        System.out.println("min: " + numbers.stream().min(Integer::compareTo).orElseThrow());
        System.out.println("max: " + numbers.stream().max(Integer::compareTo).orElseThrow());

        Integer[] array = numbers.stream().filter(number -> number >= 10).toArray(Integer[]::new);
        System.out.println("toArray length: " + array.length);
    }
}
