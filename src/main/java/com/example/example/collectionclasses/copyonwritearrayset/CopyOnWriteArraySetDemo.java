package com.example.collectionclasses.copyonwritearrayset;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> values = new CopyOnWriteArraySet<>();
        values.add("red");
        values.addAll(java.util.Set.of("blue", "yellow"));
        values.remove("green");
        values.add("green");
        values.add("red");

        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("Duplicate ignored; size: " + values.size());
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        System.out.println("Contains blue: " + values.contains("blue"));
        values.removeIf(color -> color.startsWith("y"));
        System.out.println("After removeIf: " + values);
        // Iterators are snapshots; updates during iteration do not alter that iterator's view.
    }
}
