package com.example.copyof.list;

import java.util.ArrayList;
import java.util.List;

/** Shows that List.copyOf() rejects a source collection containing null. */
public class ListCopyOf03NullElementsDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("Java");
        source.add(null);

        // The source may contain null, but List.copyOf() cannot copy it.
        try {
            List<String> copied = List.copyOf(source);
            System.out.println(copied); // This line is not reached.
        } catch (NullPointerException exception) {
            System.out.println("List.copyOf() rejects null elements.");
        }
    }
}
