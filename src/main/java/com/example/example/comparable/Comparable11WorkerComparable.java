package com.example.comparable;

import java.util.List;

public class Comparable11WorkerComparable {
    record Worker(String department, int age, String name) implements Comparable<Worker> {
        @Override
        public int compareTo(Worker other) {
            int result = department.compareTo(other.department);
            if (result == 0) result = Integer.compare(age, other.age);
            if (result == 0) result = name.compareTo(other.name);
            // The sequence of comparisons defines this type's single natural order.
            return result;
        }
    }

    public static void main(String[] args) {
        List<Worker> workers = List.of(
                new Worker("Sales", 28, "Ada"),
                new Worker("IT", 35, "Bo"),
                new Worker("IT", 28, "Ira"));
        System.out.println(workers.stream().sorted().toList());
    }
}
