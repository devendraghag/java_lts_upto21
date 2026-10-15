package com.example.comparable;

public class Comparable19SequenceAndRange {
    record N(int n) implements Comparable<N> {
        public int compareTo(N o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        N a = new N(10), b = new N(20), c = new N(30);
        System.out.println("ascending " + (a.compareTo(b) < 0 && b.compareTo(c) < 0));
        System.out.println("descending " + (c.compareTo(b) < 0 && b.compareTo(a) < 0));
        System.out.println("b between " + (a.compareTo(b) <= 0 && b.compareTo(c) <= 0));
        System.out.println("outside " + (b.compareTo(a) < 0 || b.compareTo(c) > 0));
    }
}
