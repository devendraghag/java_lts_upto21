package com.example.methodreferences.constructorreference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/** Harder: Map.computeIfAbsent accepts a key-to-value Function. */
public class Constructor12MapComputeIfAbsent {
    public static void main(String[] args) {
        Map<Integer, List<String>> studentsByGroupSize = new HashMap<>();

        // Both forms accept an Integer size and create an ArrayList with that initial capacity.
        Function<Integer, ArrayList<String>> lambda = size -> new ArrayList<>(size);
        Function<Integer, ArrayList<String>> reference = ArrayList::new;

        studentsByGroupSize.computeIfAbsent(3, lambda).add("Ravi");
        studentsByGroupSize.computeIfAbsent(2, reference).add("Mina");

        System.out.println(studentsByGroupSize);
    }
}
