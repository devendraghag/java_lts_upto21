package com.example.comparable;

public class Comparable18ThreeObjectRelations {
    record Rank(int n) implements Comparable<Rank> {
        public int compareTo(Rank o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        Rank a = new Rank(1), b = new Rank(2), c = new Rank(3);
        System.out.println(a.compareTo(b) < 0 && b.compareTo(c) < 0);
        System.out.println(c.compareTo(b) > 0 && b.compareTo(a) > 0);
        System.out.println(a.compareTo(b) == 0 && b.compareTo(c) == 0);
        System.out.println(a.compareTo(b) != 0 && b.compareTo(c) != 0 && a.compareTo(c) != 0);
    }
}
