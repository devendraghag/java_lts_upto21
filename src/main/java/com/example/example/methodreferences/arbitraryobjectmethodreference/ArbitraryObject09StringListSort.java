package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.ArrayList;
import java.util.List;

/** Medium: List.sort expects a Comparator, which String::compareTo supplies. */
public class ArbitraryObject09StringListSort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Priya", "amit", "Rahul"));

        // Lambda and arbitrary-object method reference have the Comparator shape.
        names.sort((left, right) -> left.compareToIgnoreCase(right));
        System.out.println("Lambda sorted: " + names);

        names = new ArrayList<>(List.of("Priya", "amit", "Rahul"));
        names.sort(String::compareToIgnoreCase);
        System.out.println("Method reference sorted: " + names);
    }
}
