package com.example.intermediateoperations;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/** Harder: filter active employees, then gather salary statistics in one collector. */
public class IntermediatePractice15SalaryStatistics {
    record Employee(String name, boolean active, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", true, 92000),
                new Employee("Dev", false, 108000),
                new Employee("Mina", true, 76000));
        DoubleSummaryStatistics stats = employees.stream()
                .filter(Employee::active)
                .collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println(stats);
    }
}