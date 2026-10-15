package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors16ToMapMergeFunction {
    record Employee(String name, String department, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering", 120_000),
                new Employee("Ravi", "Engineering", 105_000),
                new Employee("Mina", "Finance", 95_000));

        // The merge function handles repeated department keys by adding their salaries.
        Map<String, Integer> payrollByDepartment = employees.stream()
                .collect(Collectors.toMap(
                        Employee::department,
                        Employee::salary,
                        Integer::sum));

        System.out.println(payrollByDepartment);
    }
}
