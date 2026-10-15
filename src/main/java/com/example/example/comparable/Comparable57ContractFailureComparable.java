package com.example.comparable;

import java.util.List;

public class Comparable57ContractFailureComparable {
    record Cyclic(int value) implements Comparable<Cyclic> {
        @Override
        public int compareTo(Cyclic other) {
            if (value == other.value) return 0;
            // Deliberately invalid rock-paper-scissors order: 0 < 1, 1 < 2, but 2 < 0.
            return (value + 1) % 3 == other.value ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        List<Cyclic> values = List.of(new Cyclic(0), new Cyclic(1), new Cyclic(2));
        boolean transitive = values.stream().allMatch(a ->
                values.stream().allMatch(b ->
                        values.stream().allMatch(c ->
                                !(a.compareTo(b) < 0 && b.compareTo(c) < 0)
                                        || a.compareTo(c) < 0)));

        System.out.println("transitive = " + transitive);
    }
}
