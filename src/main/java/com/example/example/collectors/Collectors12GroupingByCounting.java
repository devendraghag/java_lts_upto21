package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors12GroupingByCounting {
    record Employee(String name, String department) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering"),
                new Employee("Ravi", "Engineering"),
                new Employee("Mina", "Finance"));

        // counting() is the downstream collector applied separately to each group.
        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()));

        System.out.println(countByDepartment);
    }
}
