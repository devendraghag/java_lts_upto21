package com.example.comparable;

import java.util.Arrays;

public class Comparable27ArraySortComparable {
    record Score(String name, int value) implements Comparable<Score> {
        @Override
        public int compareTo(Score other) {
            int byValue = Integer.compare(value, other.value);
            return byValue != 0 ? byValue : name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        Score[] scores = {
                new Score("Mina", 90),
                new Score("Asha", 75),
                new Score("Ravi", 90)
        };
        Arrays.sort(scores); // Uses each Score object's natural order.
        System.out.println(Arrays.toString(scores));
    }
}
