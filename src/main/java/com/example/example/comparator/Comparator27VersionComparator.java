package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator27VersionComparator {
    record Version(int major, int minor, int patch) {
        @Override
        public String toString() {
            return major + "." + minor + "." + patch;
        }
    }

    public static void main(String[] args) {
        List<Version> versions = List.of(
                new Version(1, 10, 0),
                new Version(2, 0, 0),
                new Version(1, 9, 0));

        // thenComparing only checks the next component when previous components tie.
        Comparator<Version> order = Comparator.comparingInt(Version::major)
                .thenComparingInt(Version::minor)
                .thenComparingInt(Version::patch);
        System.out.println(versions.stream().sorted(order).toList());
    }
}
