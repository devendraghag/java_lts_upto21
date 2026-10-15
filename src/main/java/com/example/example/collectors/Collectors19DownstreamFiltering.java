package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors19DownstreamFiltering {
    record Employee(String name, String department, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering", 120_000),
                new Employee("Ravi", "Engineering", 105_000),
                new Employee("Mina", "Finance", 95_000));

        // filtering is a downstream collector: departments remain even if their list is empty.
        Map<String, List<String>> highEarnersByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.filtering(
                                employee -> employee.salary() >= 110_000,
                                Collectors.mapping(Employee::name, Collectors.toList()))));

        System.out.println(highEarnersByDepartment);
    }
}
