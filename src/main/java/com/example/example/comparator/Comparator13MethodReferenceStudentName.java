package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator13MethodReferenceStudentName {
    record Student(String name, int id) {}

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Mira", 3), new Student("Asha", 2));
        // Student::name has the Function<Student, String> shape for Comparator.comparing.
        System.out.println(students.stream().sorted(Comparator.comparing(Student::name)).toList());
    }
}
