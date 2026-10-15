package com.example.comparable;

import java.util.*;

public class Comparable56NestedContractValidation {
    record N(int n) implements Comparable<N> {
        public int compareTo(N o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] x) {
        List<N> v = List.of(new N(-1), new N(0), new N(1));
        boolean trans = v.stream()
                .allMatch(a -> v.stream()
                        .allMatch(b -> v.stream()
                                .allMatch(c -> a.compareTo(b) >= 0
                                        || b.compareTo(c) >= 0
                                        || a.compareTo(c) < 0)));
        boolean sign = v.stream()
                .allMatch(a -> v.stream()
                        .allMatch(b -> Integer.signum(a.compareTo(b))
                                == -Integer.signum(b.compareTo(a))));
        System.out.println("transitive " + trans + "; sign symmetry " + sign);
        // Exhaustive only over this small sample.
    }
}
