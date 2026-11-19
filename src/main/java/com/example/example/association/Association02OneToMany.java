package com.example.association;

import java.util.ArrayList;
import java.util.List;

/** One teacher is associated with many independently-created students. */
public class Association02OneToMany {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Chen");
        teacher.addStudent(new Student("Uma"));
        teacher.addStudent(new Student("Zed"));
        teacher.students.forEach(student -> System.out.println(student.name + " learns from " + student.teacher.name));
    }
    private static final class Teacher {
        private final String name;
        private final List<Student> students = new ArrayList<>();
        private Teacher(String name) { this.name = name; }
        private void addStudent(Student student) { students.add(student); student.teacher = this; }
    }
    private static final class Student {
        private final String name;
        private Teacher teacher;
        private Student(String name) { this.name = name; }
    }
}
