package com.example.intermediateoperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Harder: intermediate filtering feeds a downstream grouping collector. */
public class IntermediatePractice14GroupingAfterFiltering {
    record Employee(String name, String department, boolean active) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "IT", true),
                new Employee("Dev", "IT", false),
                new Employee("Mina", "HR", true),
                new Employee("Ravi", "Finance", true));
        Map<String, List<String>> result = employees.stream()
                .filter(Employee::active)
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println(result);
    }
}