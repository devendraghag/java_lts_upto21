package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator41ContractAndTieValidation {
    record Rank(int value) {}

    private static int sign(int value) {
        return Integer.signum(value);
    }

    public static void main(String[] args) {
        Comparator<Rank> byValue = Comparator.comparingInt(Rank::value);
        List<Rank> values = List.of(new Rank(1), new Rank(1), new Rank(2));

        boolean signConsistent = values.stream().allMatch(a -> values.stream().allMatch(b ->
                sign(byValue.compare(a, b)) == -sign(byValue.compare(b, a))));
        boolean transitive = values.stream().allMatch(a -> values.stream().allMatch(b ->
                values.stream().allMatch(c ->
                        !(byValue.compare(a, b) <= 0 && byValue.compare(b, c) <= 0)
                                || byValue.compare(a, c) <= 0)));
        boolean firstTwoTie = byValue.compare(values.get(0), values.get(1)) == 0;

        System.out.println("sign consistent = " + signConsistent);
        System.out.println("transitive = " + transitive);
        System.out.println("first two compare equal = " + firstTwoTie);
    }
}
