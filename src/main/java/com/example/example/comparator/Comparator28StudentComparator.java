package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator28StudentComparator {
    record Student(int id, String name) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(3, "Chen"),
                new Student(1, "Asha"),
                new Student(1, "Bala"));

        // The class stays unchanged; the application supplies its ordering policy.
        Comparator<Student> byIdThenName = Comparator
                .comparingInt(Student::id)
                .thenComparing(Student::name);
        System.out.println(students.stream().sorted(byIdThenName).toList());
    }
}
