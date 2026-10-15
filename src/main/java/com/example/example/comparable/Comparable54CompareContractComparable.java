package com.example.comparable;

import java.util.List;

public class Comparable54CompareContractComparable {
    record Rank(int value) implements Comparable<Rank> {
        @Override
        public int compareTo(Rank other) {
            return Integer.compare(value, other.value);
        }
    }

    private static int sign(int value) {
        return Integer.signum(value);
    }

    public static void main(String[] args) {
        List<Rank> values = List.of(new Rank(-1), new Rank(0), new Rank(1));
        boolean signSymmetry = values.stream().allMatch(a ->
                values.stream().allMatch(b ->
                        sign(a.compareTo(b)) == -sign(b.compareTo(a))));
        boolean selfIsZero = values.stream().allMatch(value -> value.compareTo(value) == 0);
        values.stream().anyMatch(value -> value.compareTo(value) == 0);
        System.out.println("sign symmetry = " + signSymmetry);
        System.out.println("self comparison is zero = " + selfIsZero);
    }
}
