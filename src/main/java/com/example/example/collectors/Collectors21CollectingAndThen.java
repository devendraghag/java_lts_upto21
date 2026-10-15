package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors21CollectingAndThen {
    record Employee(String name, String department) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering"),
                new Employee("Ravi", "Engineering"),
                new Employee("Mina", "Finance"));

        // collectingAndThen applies List.copyOf after the downstream list collector finishes.
        Map<String, List<String>> immutableNamesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::name, Collectors.toList()),
                                List::copyOf)));

        System.out.println(immutableNamesByDepartment);
    }
}
