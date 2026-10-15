package com.example.comparable;

public class Comparable53ComparableSuperBound {
    static class Base implements Comparable<Base> {
        final int rank;
        Base(int r) {
            rank = r;
        }
        public int compareTo(Base o) {
            return Integer.compare(rank, o.rank);
        }
        public String toString() {
            return "Base(" + rank + ")";
        }
    }
    static final class Child extends Base {
        Child(int r) {
            super(r);
        }
    }
    static <T extends Comparable<? super T>> T min(T a, T b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    public static void main(String[] x) {
        Child a = new Child(8), b = new Child(3);
        System.out.println(min(a, b));
        // Child is comparable through its supertype Base; ? super T admits that.
    }
}
