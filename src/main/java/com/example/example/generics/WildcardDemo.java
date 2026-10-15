package com.example.generics;

import java.util.ArrayList;
import java.util.List;

/** Demonstrates unbounded, extends-bounded, and super-bounded wildcards. */
public class WildcardDemo {
    private static double sum(List<? extends Number> values) {
        double total = 0;
        for (Number value : values) {
            total += value.doubleValue();
        }
        return total;
    }

    private static void addSampleIntegers(List<? super Integer> destination) {
        destination.add(10);
        destination.add(20);
    }

    private static void printAll(List<?> values) {
        for (Object value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> decimals = List.of(1.5, 2.5);
        System.out.println("Integer sum: " + sum(integers));
        System.out.println("Decimal sum: " + sum(decimals));

        List<Number> numbers = new ArrayList<>();
        addSampleIntegers(numbers);
        printAll(numbers);
    }
}
