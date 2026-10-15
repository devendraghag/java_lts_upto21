package com.example.generics;

import java.util.List;

/** Demonstrates an upper-bounded type parameter. */
public class BoundedTypeParameterDemo {
    private static <T extends Number> double sum(List<T> numbers) {
        double total = 0;
        for (T number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(List.of(1, 2, 3)));
        System.out.println(sum(List.of(1.5, 2.5)));
    }
}
