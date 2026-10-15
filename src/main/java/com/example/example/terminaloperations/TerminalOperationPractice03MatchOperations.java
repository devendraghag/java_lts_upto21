package com.example.terminaloperations;

import java.util.List;
import java.util.function.Predicate;

/** Easy+: anyMatch, allMatch, and noneMatch each return a boolean terminal result. */
public class TerminalOperationPractice03MatchOperations {
    public static void main(String[] args) {
        List<Integer> ages = List.of(19, 22, 31, 44);
        Predicate<Integer> adult = age -> age >= 18;
        Predicate<Integer> senior = age -> age >= 65;

        System.out.println("Any senior: " + ages.stream().anyMatch(senior));
        System.out.println("All adults: " + ages.stream().allMatch(adult));
        System.out.println("No senior: " + ages.stream().noneMatch(senior));
        System.out.println("Method reference: " + ages.stream().allMatch(TerminalOperationPractice03MatchOperations::isAdult));
    }

    private static boolean isAdult(Integer age) {
        return age >= 18;
    }
}
