package com.example.comparable;

import java.util.*;

public class Comparable60InterviewComposite {
    record Release(int major, int minor, int patch) implements Comparable<Release> {
        public int compareTo(Release o) {
            int r = Integer.compare(major, o.major);
            if (r == 0) r = Integer.compare(minor, o.minor);
            if (r == 0) r = Integer.compare(patch, o.patch);
            return r;
        }
        public String toString() {
            return major + "." + minor + "." + patch;
        }
    }

    public static void main(String[] x) {
        List<Release> releases = List.of(
                new Release(2, 1, 0),
                new Release(1, 9, 8),
                new Release(2, 0, 5),
                new Release(2, 1, 0));
        System.out.println("latest " + releases.stream().max(Comparator.naturalOrder()).orElseThrow());
        System.out.println("top two " + releases.stream().sorted().skip(2).toList());
        TreeSet<Release> unique = new TreeSet<>(releases);
        System.out.println("ordered unique " + unique);
        // Stream and TreeSet use compareTo-based natural ordering.
    }
}
