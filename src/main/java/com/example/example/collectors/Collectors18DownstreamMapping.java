package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors18DownstreamMapping {
    record Employee(String name, String department) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering"),
                new Employee("Ravi", "Engineering"),
                new Employee("Mina", "Finance"));

        // mapping transforms each Employee before the downstream list collector stores it.
        Map<String, List<String>> namesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())));

        System.out.println("Engineering names = " + namesByDepartment.get("Engineering"));
        System.out.println("Finance names = " + namesByDepartment.get("Finance"));
    }
}
