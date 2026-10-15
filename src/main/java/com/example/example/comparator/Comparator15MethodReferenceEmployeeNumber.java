package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator15MethodReferenceEmployeeNumber {
    record Employee(long employeeNumber, String name) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(9_000_000_002L, "Bo"),
                new Employee(9_000_000_001L, "Asha"));
        // Employee::employeeNumber is a ToLongFunction<Employee>.
        System.out.println(employees.stream()
                .sorted(Comparator.comparingLong(Employee::employeeNumber)).toList());
    }
}
