package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator09LambdaEmployeeSalary {
    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 90_000), new Employee("Bo", 75_000));
        Comparator<Employee> bySalary = (a, b) -> Double.compare(a.salary(), b.salary());
        System.out.println(employees.stream().sorted(bySalary).toList());
    }
}
