package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator60TopThreeEmployees {
    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 90_000),
                new Employee("Bo", 120_000),
                new Employee("Mira", 75_000),
                new Employee("Zoe", 105_000));
        Comparator<Employee> highestSalaryFirst = Comparator
                .comparingDouble(Employee::salary).reversed()
                .thenComparing(Employee::name);
        System.out.println(employees.stream().sorted(highestSalaryFirst).limit(3).toList());
    }
}
