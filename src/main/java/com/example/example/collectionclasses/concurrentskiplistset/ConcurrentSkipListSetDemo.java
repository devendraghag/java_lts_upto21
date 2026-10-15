package com.example.collectionclasses.concurrentskiplistset;

import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetDemo {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> values = new ConcurrentSkipListSet<>();
        values.add(30);
        values.add(10);
        values.add(20);
        values.addAll(java.util.Set.of(5, 40));

        for (Integer value : values) {
            System.out.println(value); // Sorted iteration.
        }

        System.out.println("First/last: " + values.first() + " / " + values.last());
        System.out.println("Descending view: " + values.descendingSet());
        System.out.println("TreeSet snapshot: " + new TreeSet<>(values));
        System.out.println("Poll first: " + values.pollFirst());
        System.out.println("Lower / higher than 20: " + values.lower(20) + " / " + values.higher(20));
        // JDK 21 reversed() gives a reverse-order view of this sorted, sequenced set.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        // addFirst/addLast are unsupported because the comparator controls encounter order.
    }
}
