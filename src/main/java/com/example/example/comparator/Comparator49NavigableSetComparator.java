package com.example.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class Comparator49NavigableSetComparator {
    record Score(int value) {
        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static void main(String[] args) {
        TreeSet<Score> scores = new TreeSet<>(
                Comparator.comparingInt(Score::value).reversed());
        scores.add(new Score(10));
        scores.add(new Score(30));
        scores.add(new Score(50));
        scores.add(new Score(70));

        Score key = new Score(50);
        // lower/higher are defined by this set's comparator order, not numeric intuition.
        System.out.println("lower = " + scores.lower(key));
        System.out.println("floor = " + scores.floor(key));
        System.out.println("ceiling = " + scores.ceiling(key));
        System.out.println("higher = " + scores.higher(key));
        System.out.println("descending = " + scores.descendingSet());
    }
}
