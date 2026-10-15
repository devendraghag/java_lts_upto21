package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator40CompareContractComparator {
    record Rank(int value) {}

    private static int sign(int value) {
        return Integer.signum(value);
    }

    public static void main(String[] args) {
        List<Rank> values = List.of(new Rank(-1), new Rank(0), new Rank(1));
        Comparator<Rank> order = Comparator.comparingInt(Rank::value);
        boolean signSymmetry = values.stream().allMatch(a ->
                values.stream().allMatch(b ->
                        sign(order.compare(a, b)) == -sign(order.compare(b, a))));
        boolean selfIsZero = values.stream().allMatch(value -> order.compare(value, value) == 0);
        System.out.println("sign symmetry = " + signSymmetry);
        System.out.println("self comparison is zero = " + selfIsZero);
    }
}
