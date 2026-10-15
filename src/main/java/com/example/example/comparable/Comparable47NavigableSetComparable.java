package com.example.comparable;

import java.util.TreeSet;

public class Comparable47NavigableSetComparable {
    record Score(int value) implements Comparable<Score> {
        @Override
        public int compareTo(Score other) {
            return Integer.compare(value, other.value);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static void main(String[] args) {
        TreeSet<Score> scores = new TreeSet<>();
        scores.add(new Score(10));
        scores.add(new Score(30));
        scores.add(new Score(50));
        scores.add(new Score(70));

        Score key = new Score(50);
        System.out.println("lower = " + scores.lower(key));
        System.out.println("floor = " + scores.floor(key));
        System.out.println("ceiling = " + scores.ceiling(key));
        System.out.println("higher = " + scores.higher(key));
        System.out.println("descending = " + scores.descendingSet());
    }
}
