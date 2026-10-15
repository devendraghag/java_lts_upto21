package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors20DownstreamFlatMapping {
    record Employee(String name, String department, List<String> skills) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering", List.of("Java", "SQL")),
                new Employee("Ravi", "Engineering", List.of("Java", "Cloud")),
                new Employee("Mina", "Finance", List.of("Excel", "SQL")));

        // flatMapping sends each employee's skills into the department's downstream collector.
        Map<String, List<String>> skillsByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.flatMapping(
                                employee -> employee.skills().stream(),
                                Collectors.toList())));

        System.out.println("Engineering skills = " + skillsByDepartment.get("Engineering"));
        System.out.println("Finance skills = " + skillsByDepartment.get("Finance"));
    }
}
