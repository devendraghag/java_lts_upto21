package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator57StreamMinMax {
    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 90_000),
                new Employee("Bo", 120_000),
                new Employee("Mira", 75_000));
        Comparator<Employee> bySalary = Comparator.comparingDouble(Employee::salary);
        System.out.println("minimum = " + employees.stream().min(bySalary).orElseThrow());
        System.out.println("maximum = " + employees.stream().max(bySalary).orElseThrow());
    }
}
