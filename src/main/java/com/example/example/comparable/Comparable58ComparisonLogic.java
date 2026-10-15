package com.example.comparable;

public class Comparable58ComparisonLogic {
    record N(int n) implements Comparable<N> {
        public int compareTo(N o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        N a = new N(1), b = new N(2), c = new N(3);
        System.out.println("ascending and distinct " + (a.compareTo(b) < 0 && b.compareTo(c) < 0));
        System.out.println("a is endpoint OR equals b " + (a.compareTo(c) == 0 || a.compareTo(b) == 0));
        System.out.println("not a before b " + !(a.compareTo(b) < 0));
    }
}
