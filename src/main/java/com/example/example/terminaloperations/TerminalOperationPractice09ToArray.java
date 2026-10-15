package com.example.terminaloperations;

import java.util.Arrays;
import java.util.List;

/** Medium: toArray(IntFunction) creates an array of the requested element type. */
public class TerminalOperationPractice09ToArray {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Dev", "Mina");

        String[] lambdaArray = names.stream().toArray(size -> new String[size]);
        String[] referenceArray = names.stream().toArray(String[]::new);

        System.out.println(Arrays.toString(lambdaArray));
        System.out.println(Arrays.toString(referenceArray));
    }
}
