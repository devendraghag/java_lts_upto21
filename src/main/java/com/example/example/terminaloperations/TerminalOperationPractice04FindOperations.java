package com.example.terminaloperations;

import java.util.List;

/** Easy+: findFirst and findAny return Optional because a match may not exist. */
public class TerminalOperationPractice04FindOperations {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ben", "Amit", "Zara");

        System.out.println("First matching name: "
                + names.stream().filter(name -> name.startsWith("A")).findFirst());
        System.out.println("Any matching name: "
                + names.parallelStream().filter(name -> name.startsWith("A")).findAny());
        System.out.println("No match: "
                + names.stream().filter(name -> name.startsWith("X")).findFirst());
    }
}
