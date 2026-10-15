package com.example.comparable;

import java.util.Collections;
import java.util.List;

public class Comparable48MinMaxComparable {
    record Student(int id, String name) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            return Integer.compare(id, other.id);
        }
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(30, "Cora"),
                new Student(10, "Ari"),
                new Student(20, "Bo"));
        System.out.println("natural minimum = " + Collections.min(students));
        System.out.println("natural maximum = " + Collections.max(students));
    }
}
