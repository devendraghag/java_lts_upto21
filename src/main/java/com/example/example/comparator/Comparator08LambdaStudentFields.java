package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator08LambdaStudentFields {
    record Student(int id, String name) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(2, "Bo"), new Student(1, "Zara"), new Student(1, "Asha"));
        Comparator<Student> byIdThenName = (a, b) -> {
            int byId = Integer.compare(a.id(), b.id());
            return byId != 0 ? byId : a.name().compareTo(b.name());
        };
        System.out.println(students.stream().sorted(byIdThenName).toList());
    }
}
