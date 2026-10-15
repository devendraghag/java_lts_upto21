package com.example.terminaloperations;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/** Medium+: toMap needs a merge function when multiple inputs produce the same key. */
public class TerminalOperationPractice13ToMapMerge {
    record Sale(String product, int quantity) {
    }

    public static void main(String[] args) {
        List<Sale> sales = List.of(
                new Sale("Keyboard", 2),
                new Sale("Mouse", 3),
                new Sale("Keyboard", 4));
        BinaryOperator<Integer> addQuantities = Integer::sum;

        Map<String, Integer> totals = sales.stream().collect(Collectors.toMap(
                Sale::product,
                Sale::quantity,
                addQuantities));

        System.out.println(totals);
    }
}
