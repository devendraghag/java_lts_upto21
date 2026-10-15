package com.example.comparable;

import java.util.*;

public class Comparable29SecondHighestNatural {
    record Grade(String student, int points) implements Comparable<Grade> {
        public int compareTo(Grade o) {
            return Integer.compare(points, o.points);
        }
    }

    public static void main(String[] x) {
        List<Grade> g = List.of(new Grade("A", 90), new Grade("B", 100), new Grade("C", 95));
        System.out.println(g.stream().sorted().skip(g.size()-2).findFirst().orElseThrow());
        // Natural ascending order; skip to the second-highest item.
    }
}
