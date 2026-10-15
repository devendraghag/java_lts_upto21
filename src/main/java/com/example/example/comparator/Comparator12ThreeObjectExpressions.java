package com.example.comparator;

import java.util.Comparator;

public class Comparator12ThreeObjectExpressions {
    public static void main(String[] args) {
        Comparator<Integer> ascending = Integer::compare;
        int a = 1, b = 2, c = 3;
        System.out.println("a < b < c = " + (
                ascending.compare(a, b) < 0 && ascending.compare(b, c) < 0));

        Comparator<Integer> descending = Comparator.reverseOrder();
        int x = 3, y = 2, z = 1;
        System.out.println("x > y > z = " + (
                descending.compare(x, y) < 0 && descending.compare(y, z) < 0));

        Comparator<String> byLength = Comparator.comparingInt(String::length);
        String p = "cat", q = "sun", r = "dog";
        System.out.println("p == q == r in this ordering = " + (
                byLength.compare(p, q) == 0 && byLength.compare(q, r) == 0));
    }
}
