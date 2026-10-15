package com.example.collectionclasses.vector;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> values = new Vector<>();
        values.add("red");
        values.addElement("green");
        values.insertElementAt("blue", 1);
        values.addAll(java.util.List.of("amber", "white"));
        values.setSize(4); // Trims the final element; expansion would add null slots.
        values.removeIf(color -> color.equals("white"));

        Enumeration<String> elements = values.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }

        String[] array = values.toArray(String[]::new);
        System.out.println("Capacity: " + values.capacity());
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Array length: " + array.length);
        System.out.println("First / last: " + values.firstElement() + " / " + values.lastElement());
        // Vector is a sequenced List in JDK 21; reversed() returns a reverse-order view.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        values.addFirst("violet");
        System.out.println("JDK 21 getFirst: " + values.getFirst());
    }
}
