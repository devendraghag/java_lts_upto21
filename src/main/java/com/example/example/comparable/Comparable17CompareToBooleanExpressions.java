package com.example.comparable;

public class Comparable17CompareToBooleanExpressions {
    record Score(int n) implements Comparable<Score> {
        public int compareTo(Score o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        Score a = new Score(10), b = new Score(20), e = new Score(10);
        System.out.println(a.compareTo(b) < 0);
        System.out.println(b.compareTo(a) > 0);
        System.out.println(a.compareTo(e) == 0);
        System.out.println(a.compareTo(e) <= 0);
        System.out.println(b.compareTo(a) >= 0);
        System.out.println(a.compareTo(b) != 0);
        // Test sign, not exact magnitude.
    }
}
