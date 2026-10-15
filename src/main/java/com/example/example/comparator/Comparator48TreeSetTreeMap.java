package com.example.comparator;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Comparator48TreeSetTreeMap {
    public static void main(String[] args) {
        Comparator<String> byLengthThenText = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());

        TreeSet<String> words = new TreeSet<>(byLengthThenText);
        words.add("pear");
        words.add("fig");
        words.add("plum");
        System.out.println("TreeSet = " + words);

        TreeMap<String, Integer> scores = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        scores.put("java", 80);
        scores.put("JAVA", 95);
        System.out.println("TreeMap size = " + scores.size());
        System.out.println("TreeMap lookup = " + scores.get("JaVa"));
    }
}
