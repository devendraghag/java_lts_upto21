package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator42ContractFailureComparator {
    record Cyclic(int value) {}

    public static void main(String[] args) {
        Comparator<Cyclic> order = (left, right) -> {
            if (left.value() == right.value()) return 0;
            // Deliberately invalid cycle: never use this comparator to sort real application data.
            return (left.value() + 1) % 3 == right.value() ? -1 : 1;
        };
        List<Cyclic> values = List.of(new Cyclic(0), new Cyclic(1), new Cyclic(2));
        boolean transitive = values.stream().allMatch(a ->
                values.stream().allMatch(b ->
                        values.stream().allMatch(c ->
                                !(order.compare(a, b) < 0 && order.compare(b, c) < 0)
                                        || order.compare(a, c) < 0)));
        System.out.println("transitive = " + transitive);
    }
}
