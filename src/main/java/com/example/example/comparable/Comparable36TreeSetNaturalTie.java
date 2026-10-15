package com.example.comparable;

import java.util.TreeSet;

public class Comparable36TreeSetNaturalTie {
    record Employee(String name, int salary) implements Comparable<Employee> {
        @Override
        public int compareTo(Employee other) {
            // Intentionally salary-only: equal salaries compare as zero, even for different names.
            return Integer.compare(salary, other.salary);
        }
    }

    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee("Ada", 100));
        employees.add(new Employee("Grace", 100));
        System.out.println("size = " + employees.size());
        System.out.println(employees);
    }
}
