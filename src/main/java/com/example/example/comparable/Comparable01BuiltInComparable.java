package com.example.comparable;

import java.util.ArrayList;
import java.util.List;

public class Comparable01BuiltInComparable {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 1, 3));
        numbers.sort(null); // null means use Integer's built-in natural order
        //a Comparator that can compare objects of type E or any superclass of E.
        System.out.println(numbers);

        List<String> names = new ArrayList<>(List.of("Zoe", "Ada", "Linus"));
        names.sort(null); // String already implements Comparable<String>
        System.out.println(names);
    }
}