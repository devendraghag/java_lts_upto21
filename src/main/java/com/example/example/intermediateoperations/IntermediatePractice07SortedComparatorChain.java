package com.example.intermediateoperations;

import java.util.Comparator;
import java.util.List;

/** Medium: sorted accepts a Comparator; tie-breaking compares names after scores. */
public class IntermediatePractice07SortedComparatorChain {
    record Student(String name, int score) {}

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Mina", 88), new Student("Asha", 95), new Student("Dev", 88));
        List<Student> result = students.stream()
                .sorted(Comparator.comparingInt(Student::score).reversed().thenComparing(Student::name))
                .toList();
        System.out.println(result);
    }
}