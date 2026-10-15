package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator59SecondHighestDistinctSalary {
    record Employee(String name, int salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 120_000),
                new Employee("Bo", 120_000),
                new Employee("Mira", 100_000),
                new Employee("Zoe", 80_000));

        // distinct() makes "second highest" mean the second distinct salary, not the second employee.
        int secondHighest = employees.stream()
                .map(Employee::salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("second-highest distinct salary = " + secondHighest);
    }
}
