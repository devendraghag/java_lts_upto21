package com.example.comparator;

import java.util.Comparator;

public class Comparator11AllComparisonExpressions {
    public static void main(String[] args) {
        Comparator<Integer> order = Integer::compare;
        int a = 4, b = 4, c = 9;

        System.out.println("a < c: " + (order.compare(a, c) < 0));
        System.out.println("c > a: " + (order.compare(c, a) > 0));
        System.out.println("a == b: " + (order.compare(a, b) == 0));
        System.out.println("a <= b: " + (order.compare(a, b) <= 0));
        System.out.println("c >= b: " + (order.compare(c, b) >= 0));
        System.out.println("a != c: " + (order.compare(a, c) != 0));
    }
}
