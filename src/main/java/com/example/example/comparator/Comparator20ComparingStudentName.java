package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator20ComparingStudentName {
    record Student(String name, int id) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Zoe", 1), new Student("Asha", 3), new Student("Asha", 2));
        Comparator<Student> order = Comparator.comparing(Student::name)
                .thenComparingInt(Student::id);
        System.out.println(students.stream().sorted(order).toList());
    }
}
