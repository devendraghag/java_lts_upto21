package com.example.comparable;

import java.util.*;

public class Comparable55ContractValidCheck {
    record N(int n) implements Comparable<N> {
        public int compareTo(N o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        List<N> v = List.of(new N(1), new N(2), new N(3));
        boolean self = v.stream().allMatch(a -> a.compareTo(a) == 0);
        boolean symmetry = v.stream()
                .allMatch(a -> v.stream()
                        .allMatch(b -> Integer.signum(a.compareTo(b))
                                == -Integer.signum(b.compareTo(a))));
        boolean trans = v.stream()
                .allMatch(a -> v.stream()
                        .allMatch(b -> v.stream()
                                .allMatch(c -> !(a.compareTo(b) < 0
                                        && b.compareTo(c) < 0)
                                        || a.compareTo(c) < 0)));
        System.out.println("self=" + self + " symmetry=" + symmetry + " transitive=" + trans);
        // Sample validation only.
    }
}
