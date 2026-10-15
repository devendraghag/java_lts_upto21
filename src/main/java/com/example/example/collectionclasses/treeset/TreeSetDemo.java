package com.example.collectionclasses.treeset;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> values = new TreeSet<>();
        values.add(30);
        values.add(10);
        values.add(20);
        values.addAll(java.util.Set.of(5, 40));
        values.add(20);

        for (Integer value : values) {
            System.out.println(value); // Natural sorted order.
        }

        System.out.println("First/last: " + values.first() + " / " + values.last());
        System.out.println("Below 25: " + values.headSet(25));
        System.out.println("Descending view: " + values.descendingSet());
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Higher than 20: " + values.higher(20));
        System.out.println("Lower than 20: " + values.lower(20));
        System.out.println("Poll first / last: " + values.pollFirst() + " / " + values.pollLast());
        // JDK 21 TreeSet implements SequencedSet; sorted order defines its sequence.
        System.out.println("JDK 21 reverse view: " + values.reversed());
        // addFirst/addLast exist through SequencedCollection but throw UnsupportedOperationException
        // for TreeSet because its comparator controls the element order.
    }
}
