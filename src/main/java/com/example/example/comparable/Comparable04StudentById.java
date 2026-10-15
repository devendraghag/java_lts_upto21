package com.example.comparable;

import java.util.*;

public class Comparable04StudentById {
    record Student(int id, String name) implements Comparable<Student> {
        public int compareTo(Student o) {
            return Integer.compare(id, o.id);
        }
    }

    public static void main(String[] x) {
        System.out.println(List.of(new Student(3, "Chen"), new Student(1, "Asha")).stream().sorted().toList());
        // Student.compareTo defines natural id order.
    }
}
