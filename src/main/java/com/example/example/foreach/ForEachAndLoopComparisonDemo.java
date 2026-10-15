package com.example.foreach;

import java.util.List;

/** Compares forEach with the enhanced for statement. */
public class ForEachAndLoopComparisonDemo {
    public static void main(String[] args) {
        List<Integer> values = List.of(10, 20, 30);

        System.out.println("Iterable.forEach method:");
        values.forEach(value -> System.out.println(value));

        System.out.println("Enhanced for statement:");
        for (int value : values) {
            System.out.println(value);
        }
    }
}
