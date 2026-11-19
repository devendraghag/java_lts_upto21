package com.example.association;

/** Two independent objects know about one another. */
public class Association01OneToOne {
    public static void main(String[] args) {
        Student student = new Student("Ira");
        Course course = new Course("Java Basics");
        student.enroll(course);
        System.out.println(student.name + " enrolled in " + student.course.title);
    }
    private static final class Student {
        private final String name;
        private Course course;
        private Student(String name) { this.name = name; }
        private void enroll(Course course) { this.course = course; }
    }
    private static final class Course {
        private final String title;
        private Course(String title) { this.title = title; }
    }
}
