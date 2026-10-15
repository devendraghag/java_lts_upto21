package com.example.comparable;

import java.util.List;

public class Comparable08VersionComparable {
    record Version(int major, int minor, int patch) implements Comparable<Version> {
        @Override
        public int compareTo(Version other) {
            int result = Integer.compare(major, other.major); // return to result
            if (result == 0) result = Integer.compare(minor, other.minor);
            if (result == 0) result = Integer.compare(patch, other.patch);
            // Compare numeric components in order; text comparison would misorder 1.10 and 1.9.
            return result;
        }

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
        System.out.println(versions.stream().sorted().toList());
        //means to say i have put sorted on version object so comparable method get called
    }
}
