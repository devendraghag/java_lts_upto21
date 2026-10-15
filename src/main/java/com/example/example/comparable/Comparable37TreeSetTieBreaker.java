package com.example.comparable;

import java.util.*;

public class Comparable37TreeSetTieBreaker {
    record Emp(String name, int salary) implements Comparable<Emp> {
        public int compareTo(Emp o) {
            int r = Integer.compare(salary, o.salary);
            return r != 0 ? r : name.compareTo(o.name);
        }
    }

    public static void main(String[] x) {
        TreeSet<Emp> s = new TreeSet<>(List.of(new Emp("Dev", 90000), new Emp("Asha", 90000)));
        System.out.println(s);
        // Name breaks salary ties.
    }
}
