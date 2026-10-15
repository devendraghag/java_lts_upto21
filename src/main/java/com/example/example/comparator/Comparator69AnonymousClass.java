package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator69AnonymousClass {
    record Student(int id, String name) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(3, "Chen"),
                new Student(1, "Bala"),
                new Student(1, "Asha"));

        // Anonymous classes spell out the Comparator implementation explicitly.
        Comparator<Student> byIdThenName = new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                int byId = Integer.compare(left.id(), right.id());
                return byId != 0 ? byId : left.name().compareTo(right.name());
            }
        };
        System.out.println(students.stream().sorted(byIdThenName).toList());
    }
}
