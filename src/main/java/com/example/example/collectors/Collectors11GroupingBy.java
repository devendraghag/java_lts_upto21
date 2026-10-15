package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors11GroupingBy {
    record Employee(String name, String department) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering"),
                new Employee("Ravi", "Engineering"),
                new Employee("Mina", "Finance"));

        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));

        System.out.println("Engineering = " + byDepartment.get("Engineering"));
        System.out.println("Finance = " + byDepartment.get("Finance"));
    }
}
