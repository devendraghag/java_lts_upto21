package com.example.comparable;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeSet;

public class Comparable40BigDecimalComparable {
    record Amount(BigDecimal value) implements Comparable<Amount> {
        @Override
        public int compareTo(Amount other) {
            // BigDecimal natural order compares numeric value and ignores scale when deciding order.
            return value.compareTo(other.value);
        }
    }

    public static void main(String[] args) {
        List<Amount> amounts = List.of(
                new Amount(new BigDecimal("1.00")),
                new Amount(new BigDecimal("0.9")),
                new Amount(new BigDecimal("1.0")));
        System.out.println(amounts.stream().sorted().toList());

        TreeSet<Amount> uniqueByNaturalOrder = new TreeSet<>(amounts);
        System.out.println("TreeSet size = " + uniqueByNaturalOrder.size());
    }
}
