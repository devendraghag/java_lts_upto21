package com.example.interviewprograms.p04_count_employees_with_predicate;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 04/50: Count Employees with Predicate — Easy. Java 8+ standalone example. */
public class CountEmployeesWithPredicate {
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
        long lambdaCount = list.stream().filter(e -> e.getSalary() > 50000).count();
        Predicate<Employee> highSalary = e -> e.getSalary() > 50000;
        long predicateCount = list.stream().filter(highSalary).count();
        long referenceCount = list.stream().filter(Employee::hasHighSalary).count();
        System.out.println("Lambda count: " + lambdaCount);
        System.out.println("Predicate count: " + predicateCount);
        System.out.println("Method reference count: " + referenceCount);
        System.out.println("Matching employees:");
        list.stream().filter(highSalary).forEach(System.out::println);
        Predicate<Employee> nameStartsWithP = e -> e.getName().startsWith("P");
        System.out.println("AND: " + list.stream().filter(highSalary.and(nameStartsWithP)).count());
        System.out.println("OR: " + list.stream().filter(highSalary.or(nameStartsWithP)).count());
        System.out.println("NOT: " + list.stream().filter(highSalary.negate()).count());
    }
}
