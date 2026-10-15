package com.example.unmodifiable.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Shows that Collections.unmodifiableList() returns a view backed by its source. */
public class UnmodifiableList01BackedViewDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("Java");
        source.add("SQL");

        // The wrapper blocks changes made through the view, but it does not copy
        // the source list. Changes made directly to source remain visible here.
        List<String> view = Collections.unmodifiableList(source);
        System.out.println("View before source change: " + view);

        source.add("Spring");

        System.out.println("Source after adding Spring: " + source);
        System.out.println("View reflects source change: " + view);
    }
}
