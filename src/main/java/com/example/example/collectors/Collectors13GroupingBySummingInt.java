package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors13GroupingBySummingInt {
    record Employee(String name, String department, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering", 120_000),
                new Employee("Ravi", "Engineering", 105_000),
                new Employee("Mina", "Finance", 95_000));

        Map<String, Integer> salaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.summingInt(Employee::salary)));

        System.out.println(salaryByDepartment);
    }
}
