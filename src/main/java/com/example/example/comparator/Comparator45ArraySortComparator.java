package com.example.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator45ArraySortComparator {
    record Score(String name, int value) {}

    public static void main(String[] args) {
        Score[] scores = {
                new Score("Mina", 90),
                new Score("Asha", 75),
                new Score("Ravi", 90)
        };

        // The supplied comparator provides descending score and ascending name for ties.
        Comparator<Score> order = Comparator.comparingInt(Score::value)
                .reversed()
                .thenComparing(Score::name);
        Arrays.sort(scores, order);
        System.out.println(Arrays.toString(scores));
    }
}
