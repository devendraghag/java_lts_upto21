package com.example.comparator;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Comparator50BigDecimalComparator {
    record Amount(BigDecimal value) {}

    public static void main(String[] args) {
        List<Amount> amounts = List.of(
                new Amount(new BigDecimal("1.00")),
                new Amount(new BigDecimal("0.9")),
                new Amount(new BigDecimal("1.0")));

        // Numeric value is primary; scale is a tie-breaker so 1.0 and 1.00 stay distinct in sorted sets.
        Comparator<Amount> byValueThenScale = Comparator
                .comparing(Amount::value)
                .thenComparingInt(amount -> amount.value().scale());
        System.out.println(amounts.stream().sorted(byValueThenScale).toList());

        TreeSet<Amount> uniqueByComparator = new TreeSet<>(byValueThenScale);
        uniqueByComparator.addAll(amounts);
        System.out.println("TreeSet size = " + uniqueByComparator.size());
    }
}
