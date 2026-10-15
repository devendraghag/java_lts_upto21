package com.example.comparable;

import java.util.*;

public class Comparable44NaturalOrderInCollections {

    public static void main(String[] x) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("pear");
        q.add("apple");
        q.add("plum");
        while (!q.isEmpty())System.out.println(q.poll());
        // PriorityQueue without comparator uses String natural order at its head.
    }
}
