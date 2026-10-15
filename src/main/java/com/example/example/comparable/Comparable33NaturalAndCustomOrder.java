package com.example.comparable;

import java.util.*;

public class Comparable33NaturalAndCustomOrder {
    record Student(int id, String name) implements Comparable<Student> {
        public int compareTo(Student o) {
            return Integer.compare(id, o.id);
        }
    }

    public static void main(String[] x) {
        List<Student> s = List.of(new Student(2, "Asha"), new Student(1, "Mira"));
        System.out.println("natural id " + s.stream().sorted().toList());
        System.out.println("custom name " + s.stream().sorted(Comparator.comparing(Student::name)).toList());
        // Comparable is default; Comparator is an alternative for this operation.
    }
}
