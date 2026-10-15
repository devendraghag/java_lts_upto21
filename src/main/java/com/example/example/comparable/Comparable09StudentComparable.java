package com.example.comparable;

import java.util.ArrayList;
import java.util.List;

public class Comparable09StudentComparable {
    record Student(int id, String name) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            int byId = Integer.compare(id, other.id);
            // The name tie-breaker keeps different students with the same id ordered distinctly.
            return byId != 0 ? byId : name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student(3, "Chen"),
                new Student(1, "Asha"),
                new Student(1, "Bala")));
        students.sort(null);
        System.out.println(students);
    }
}