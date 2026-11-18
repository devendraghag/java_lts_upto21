package com.example.example.terminaloperations;

import java.util.List;

/** reduce combines stream values into one result. */
public class TerminalOperation04Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4);

        int product = numbers.stream()
                .reduce(1, (left, right) -> left * right);

        System.out.println("Product: " + product);
    }
}
