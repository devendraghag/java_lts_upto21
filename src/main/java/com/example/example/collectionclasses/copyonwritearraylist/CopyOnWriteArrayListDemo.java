package com.example.collectionclasses.copyonwritearraylist;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> values = new CopyOnWriteArrayList<>();
        values.add("one");
        values.add("two");
        values.addAll(java.util.List.of("four", "five"));
        values.removeIf(value -> value.equals("five"));

        for (String value : values) {
            System.out.println(value);
            if (value.equals("one")) {
                values.add("three"); // Iterator traverses the original snapshot.
            }
        }

        System.out.println("Current list: " + values);
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        values.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll: " + values);
        // JDK 21 List APIs apply: reversed() is a reverse-order view; writes copy the backing array.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        values.addFirst("zero");
        System.out.println("First / last: " + values.getFirst() + " / " + values.getLast());
    }
}
