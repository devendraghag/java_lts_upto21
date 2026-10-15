package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator21ComparingIntStudentId {
    record Student(int id, String name) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(40, "Ira"), new Student(12, "Mina"), new Student(25, "Bo"));
        Comparator<Student> byId = Comparator.comparingInt(Student::id);
        System.out.println(students.stream().sorted(byId).toList());
    }
}
