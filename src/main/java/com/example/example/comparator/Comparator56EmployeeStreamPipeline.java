package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator56EmployeeStreamPipeline {
    record Employee(String name, String department, double salary, boolean active) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "IT", 110_000, true),
                new Employee("Bo", "Sales", 95_000, true),
                new Employee("Mira", "IT", 80_000, false),
                new Employee("Zoe", "IT", 105_000, true));

        List<String> activeItNames = employees.stream()
                .filter(Employee::active)
                .filter(employee -> "IT".equals(employee.department()))
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .map(Employee::name)
                .toList();
        System.out.println(activeItNames);
    }
}
