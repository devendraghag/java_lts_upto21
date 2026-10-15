package com.example.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator58MinMaxComparator {
    record Student(int id, String name, int score) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(30, "Cora", 90),
                new Student(10, "Ari", 95),
                new Student(20, "Bo", 80));
        Comparator<Student> byScore = Comparator.comparingInt(Student::score);
        // Collections.min/max follow the supplied comparator, not the object's fields by themselves.
        System.out.println("lowest score = " + Collections.min(students, byScore));
        System.out.println("highest score = " + Collections.max(students, byScore));
    }
}
