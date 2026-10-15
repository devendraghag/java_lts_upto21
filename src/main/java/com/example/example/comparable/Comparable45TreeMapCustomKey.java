package com.example.comparable;

import java.util.*;

public class Comparable45TreeMapCustomKey {
    record Key(int id, String label) implements Comparable<Key> {
        public int compareTo(Key o) {
            return Integer.compare(id, o.id);
        }
    }

    public static void main(String[] x) {
        TreeMap<Key, String> m = new TreeMap<>();
        m.put(new Key(2, "two"), "B");
        m.put(new Key(1, "one"), "A");
        System.out.println(m);
        // TreeMap keys use compareTo for natural ordering.
    }
}
