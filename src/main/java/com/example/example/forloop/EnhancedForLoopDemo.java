package com.example.forloop;

import java.util.List;

/** Demonstrates the enhanced for loop over arrays and Iterable collections. */
public class EnhancedForLoopDemo {
    public static void main(String[] args) {
        String[] colors = {"red", "green", "blue"};
        System.out.println("Array elements:");
        for (String color : colors) {
            System.out.println(color);
        }

        List<Integer> values = List.of(10, 20, 30);
        System.out.println("List elements:");
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
