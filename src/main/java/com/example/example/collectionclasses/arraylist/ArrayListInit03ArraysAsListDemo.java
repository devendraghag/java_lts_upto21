package com.example.collectionclasses.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Article approach 3: initialize from Arrays.asList(). */
public class ArrayListInit03ArraysAsListDemo {
    public static void main(String[] args) {
        // Arrays.asList returns a fixed-size list backed by its array.
        List<String> fixedSizeSource = Arrays.asList("Asha", "Ravi", "Mina");

        // Copy it into an ArrayList when a resizable list is needed.
        ArrayList<String> names = new ArrayList<>(fixedSizeSource);
        names.add("Neha");

        System.out.println("Arrays.asList source: " + fixedSizeSource);
        System.out.println("Resizable ArrayList copy: " + names);
    }
}