package com.example.collectionclasses.arraylist;

import java.util.ArrayList;

/** Article approach 2: initialize an ArrayList with reserved capacity. */
public class ArrayListInit02InitialCapacityDemo {
    public static void main(String[] args) {
        // Capacity is reserved room, not the number of elements in the list.
        ArrayList<String> names = new ArrayList<>(10);
        System.out.println("Size before adding: " + names.size()); // Still zero.

        names.add("Asha");
        names.add("Ravi");
        names.add("Mina");

        System.out.println("Size after adding: " + names.size());
        System.out.println("Names: " + names);
    }
}