package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator31ChainDepartmentSalaryName {
    record Employee(String department, double salary, String name) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("IT", 120_000, "Zoe"),
                new Employee("IT", 100_000, "Bo"),
                new Employee("IT", 120_000, "Asha"),
                new Employee("HR", 80_000, "Mina"));

        Comparator<Employee> order = Comparator.comparing(Employee::department)
                .thenComparingDouble(Employee::salary)
                .thenComparing(Employee::name);
        System.out.println(employees.stream().sorted(order).toList());
    }
}
