package com.example.aggregation;

import java.util.ArrayList;
import java.util.List;

/** Demonstrates a bidirectional many-to-many relationship between students and courses. */
public class BidirectionalManyToManyAggregationDemo {
    public static void main(String[] args) {
        Student studentA = new Student("Asha");
        Student studentB = new Student("Ravi");
        Course java = new Course("Java");
        Course databases = new Course("Databases");

        studentA.enroll(java);
        studentA.enroll(databases);
        studentB.enroll(java);

        studentA.printCourses();
        java.printStudents();
    }

    private static final class Student {
        private final String name;
        private final List<Course> courses = new ArrayList<>();

        private Student(String name) {
            this.name = name;
        }

        private void enroll(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
                course.addStudent(this);
            }
        }

        private void printCourses() {
            System.out.println(name + " is enrolled in:");
            courses.forEach(course -> System.out.println("  " + course.name));
        }
    }

    private static final class Course {
        private final String name;
        private final List<Student> students = new ArrayList<>();

        private Course(String name) {
            this.name = name;
        }

        private void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        private void printStudents() {
            System.out.println(name + " course students:");
            students.forEach(student -> System.out.println("  " + student.name));
        }
    }
}
