package com.example.comparable;

import java.util.*;

public class Comparable35ArrayAndMethodReference {
    record Version(int major, int minor) implements Comparable<Version> {
        public int compareTo(Version o) {
            int r = Integer.compare(major, o.major);
            return r != 0 ? r : Integer.compare(minor, o.minor);
        }
        public String toString() {
            return major + "." + minor;
        }
    }

    public static void main(String[] x) {
        Version[] a = {
            new Version(3, 0), new Version(2, 9), new Version(3, 1)
        }
        ;
        Arrays.sort(a);
        Arrays.stream(a).map(Version::toString).forEach(System.out::println);
        // Arrays.sort and stream.sorted use compareTo; refs format and print.
    }
}
