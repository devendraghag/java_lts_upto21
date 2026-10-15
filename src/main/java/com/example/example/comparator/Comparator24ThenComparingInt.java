package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator24ThenComparingInt {
    record Employee(String department, int age, String name) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("IT", 30, "Bo"),
                new Employee("IT", 25, "Asha"),
                new Employee("HR", 40, "Mina"));

        Comparator<Employee> order = Comparator.comparing(Employee::department)
                .thenComparingInt(Employee::age)
                .thenComparing(Employee::name);
        System.out.println(employees.stream().sorted(order).toList());
    }
}
