package com.example.comparable;
import java.util.*;
public class Comparable02IntegerConditions {

    public static void main(String[] x) {
        Integer a = 10, b = 20; // Direct compareTo: sign means before/tied/after.
        System.out.println(a.compareTo(b) < 0);
        System.out.println(a.compareTo(b) > 0);
        System.out.println(a.compareTo(b) == 0);
        System.out.println(a.compareTo(b) <= 0);
        System.out.println(a.compareTo(b) >= 0);
        System.out.println(a.compareTo(b) != 0);
        List < Integer > v = new ArrayList < > (List.of(20, 5, 10));
        v.sort(null); // null requests natural ordering; compareTo is called internally.
        System.out.println(v);
    }
}