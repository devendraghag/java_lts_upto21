package com.example.interviewprograms.p07_any_all_and_none_match;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 07/50: Any All and None Match — Easy. Java 8+ standalone example. */
public class AnyAllAndNoneMatch {
    static class Employee {
        private final int id;
        private final String name;
        private final String department;
        private final double salary;
        private final boolean active;
        private final List<String> skills;

        Employee(int id, String name, double salary) {
            this(id, name, "General", salary, true, Collections.<String>emptyList());
        }
        Employee(int id, String name, String department, double salary) {
            this(id, name, department, salary, true, Collections.<String>emptyList());
        }
        Employee(int id, String name, String department, double salary,
                 boolean active, List<String> skills) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.active = active;
            this.skills = new ArrayList<>(skills);
        }
        int getId() { return id; }
        String getName() { return name; }
        String getDepartment() { return department; }
        double getSalary() { return salary; }
        boolean isActive() { return active; }
        List<String> getSkills() { return Collections.unmodifiableList(skills); }
        boolean hasHighSalary() { return salary > 50000; }
        @Override public String toString() { return name + " - " + salary; }
    }

    static List<Employee> employees() {
        return Arrays.asList(
            new Employee(1, "Amit", "IT", 40000, true, Arrays.asList("Java", "SQL")),
            new Employee(2, "Rahul", "HR", 60000, true, Arrays.asList("Excel", "Communication")),
            new Employee(3, "Priya", "IT", 75000, true, Arrays.asList("Java", "Spring", "SQL")),
            new Employee(4, "Sneha", "HR", 45000, false, Arrays.asList("Excel")),
            new Employee(5, "Vijay", "IT", 90000, true, Arrays.asList("Java", "AWS", "Spring")),
            new Employee(6, "Neha", "Finance", 85000, false, Arrays.asList("SQL", "Python")),
            new Employee(7, "Kiran", "Finance", 55000, true, Arrays.asList("Python", "Excel"))
        );
    }
    public static void main(String[] args) {
        List<Employee> list = employees();
        Predicate<Employee> above80k = e -> e.getSalary() > 80000;
        boolean any = list.stream().anyMatch(above80k);
        boolean all = list.stream().allMatch(e -> e.getSalary() > 0);
        boolean none = list.stream().noneMatch(e -> e.getSalary() < 0);
        System.out.println("Any above 80k: " + any);
        System.out.println("All positive: " + all);
        System.out.println("None negative: " + none);
        System.out.println("Any inactive: " + list.stream().anyMatch(e -> !e.isActive()));
    }
}
