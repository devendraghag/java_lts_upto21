package com.example.comparable;

import java.util.*;

public class Comparable46TreeMapNaturalKeys {

    public static void main(String[] x) {
        TreeMap<Integer, String> m = new TreeMap<>();
        m.put(30, "thirty");
        m.put(10, "ten");
        m.put(20, "twenty");
        System.out.println(m);
        // TreeMap without comparator uses Integer.compareTo for keys.
    }
}
