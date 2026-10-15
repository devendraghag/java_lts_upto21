package com.example.comparable;

import java.math.*;
import java.util.*;

public class Comparable41BigDecimalOrdering {

    public static void main(String[] x) {
        BigDecimal a = new BigDecimal("2.0"), b = new BigDecimal("2.00");
        System.out.println("compareTo " + a.compareTo(b));
        System.out.println("equals " + a.equals(b));
        TreeSet<BigDecimal> set = new TreeSet<>(List.of(a, b));
        System.out.println("TreeSet size " + set.size());
        // BigDecimal natural order ignores scale, equals includes scale.
    }
}
