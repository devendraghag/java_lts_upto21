package com.example.comparable;

import java.util.*;

public class Comparable30MethodReferencesWithNaturalStream {
    record Student(int id, String name) implements Comparable<Student> {
        public int compareTo(Student o) {
            return Integer.compare(id, o.id);
        }
    }
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
        List<Student> s = List.of(new Student(2, "Mira"), new Student(1, "Asha"));
        s.stream().sorted().map(Student::name).forEach(System.out::println);
        List<Version> v = List.of(new Version(2, 1), new Version(1, 9));
        v.stream().sorted().map(Version::toString).forEach(System.out::println);
        // sorted uses Comparable; method refs transform/print values.
    }
}
