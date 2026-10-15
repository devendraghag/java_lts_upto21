package com.example.terminaloperations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** Harder: collectingAndThen applies a finishing step after the downstream collection completes. */
public class TerminalOperationPractice17CollectingAndThen {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Dev", "Asha", "Mina");

        Set<String> immutableNames = names.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toSet(),
                        Set::copyOf));

        System.out.println(immutableNames);
        System.out.println("Unmodifiable set: " + immutableNames.getClass().getName());
    }
}
