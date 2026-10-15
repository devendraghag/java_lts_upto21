package com.example.terminaloperations;

import java.util.List;

/** Easy: forEachOrdered preserves encounter order for this ordered source. */
public class TerminalOperationPractice02ForEachOrdered {
    public static void main(String[] args) {
        List<Integer> values = List.of(10, 20, 30, 40, 50);

        values.parallelStream().forEach(value -> System.out.println("forEach: " + value));
        System.out.println("forEachOrdered:");
        values.parallelStream().forEachOrdered(value -> System.out.println("ordered: " + value));
    }
}
