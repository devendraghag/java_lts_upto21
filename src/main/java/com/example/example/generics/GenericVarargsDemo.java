package com.example.generics;

import java.util.Arrays;
import java.util.List;

/** Demonstrates a safe generic varargs method. */
public class GenericVarargsDemo {
    @SafeVarargs
    private static <T> List<T> asList(T... values) {
        return Arrays.asList(values);
    }

    public static void main(String[] args) {
        List<String> names = asList("Asha", "Ravi", "Maya");
        List<Integer> scores = asList(82, 91, 77);

        System.out.println(names);
        System.out.println(scores);
    }
}
