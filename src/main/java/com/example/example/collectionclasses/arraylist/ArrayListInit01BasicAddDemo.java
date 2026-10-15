package com.example.collectionclasses.arraylist;

import java.util.ArrayList;

/** Article approach 1: create an empty ArrayList, then add elements. */
public class ArrayListInit01BasicAddDemo {
    public static void main(String[] args) {
        // The diamond operator infers String from the variable's declared type.
        ArrayList<String> names = new ArrayList<>();
        names.add("Asha");
        names.add("Ravi");
        names.add("Mina");
        System.out.println("Names: " + names);
    }
}