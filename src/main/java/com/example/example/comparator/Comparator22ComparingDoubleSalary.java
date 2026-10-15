package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator22ComparingDoubleSalary {
    record Employee(String name, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Mira", 100_500.75), new Employee("Asha", 98_000.25));
        Comparator<Employee> bySalary = Comparator.comparingDouble(Employee::salary);
        System.out.println(employees.stream().sorted(bySalary).toList());
    }
}
