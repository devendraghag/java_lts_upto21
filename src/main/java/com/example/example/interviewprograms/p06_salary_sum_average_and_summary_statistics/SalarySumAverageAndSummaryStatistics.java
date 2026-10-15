package com.example.interviewprograms.p06_salary_sum_average_and_summary_statistics;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 06/50: Salary Sum Average and Summary Statistics — Easy. Java 8+ standalone example. */
public class SalarySumAverageAndSummaryStatistics {
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
        double total = list.stream().mapToDouble(Employee::getSalary).sum();
        OptionalDouble avg = list.stream().mapToDouble(Employee::getSalary).average();
        DoubleSummaryStatistics stats = list.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println("Sum: " + total);
        System.out.println("Average: " + avg.orElse(0));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Stats sum: " + stats.getSum());
    }
}
