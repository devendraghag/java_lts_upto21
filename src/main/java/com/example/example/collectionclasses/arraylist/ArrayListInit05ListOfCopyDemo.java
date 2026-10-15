package com.example.collectionclasses.arraylist;

import java.util.ArrayList;
import java.util.List;

/** Article approach 5: copy List.of() values into a mutable ArrayList. */
public class ArrayListInit05ListOfCopyDemo {
    public static void main(String[] args) {
        // List.of creates an unmodifiable list and does not accept null values.
        List<String> fixedValues = List.of("Asha", "Ravi", "Mina");

        // The ArrayList constructor copies the values into a resizable list.
        ArrayList<String> names = new ArrayList<>(fixedValues);
        names.add("Neha");

        System.out.println("List.of source: " + fixedValues);
        System.out.println("Mutable ArrayList copy: " + names);
    }
}