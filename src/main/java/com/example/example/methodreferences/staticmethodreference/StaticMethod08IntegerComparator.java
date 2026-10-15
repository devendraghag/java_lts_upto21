package com.example.methodreferences.staticmethodreference;

import java.util.Comparator;

/** Medium: Integer::compare is a static two-argument method matching Comparator<Integer>. */
public class StaticMethod08IntegerComparator {
    public static void main(String[] args) {
        Comparator<Integer> lambda = (left, right) -> Integer.compare(left, right);
        Comparator<Integer> reference = Integer::compare;

        System.out.println("compare(4, 9): " + lambda.compare(4, 9));
        System.out.println("compare(9, 4): " + reference.compare(9, 4));
        System.out.println("Negative means first value sorts before second.");
    }
}
