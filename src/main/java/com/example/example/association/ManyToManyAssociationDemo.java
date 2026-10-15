package com.example.association;

import java.util.LinkedHashSet;
import java.util.Set;

/** Demonstrates a bidirectional many-to-many association. */
public class ManyToManyAssociationDemo {
    private static final class Student {
        private final String name;
        private final Set<Course> courses = new LinkedHashSet<>();

        private Student(String name) {
            this.name = name;
        }

        private void enroll(Course course) {
            if (courses.add(course)) {
                course.students.add(this);
            }
        }
    }

    private static final class Course {
        private final String title;
        private final Set<Student> students = new LinkedHashSet<>();

        private Course(String title) {
            this.title = title;
        }
    }

    public static void main(String[] args) {
        Student maya = new Student("Maya");
        Student ravi = new Student("Ravi");
        Course java = new Course("Java");
        Course databases = new Course("Databases");

        maya.enroll(java);
        maya.enroll(databases);
        ravi.enroll(java);

        System.out.println(maya.name + " studies " + maya.courses.size() + " courses");
        System.out.println(java.title + " has " + java.students.size() + " students");
    }
}
