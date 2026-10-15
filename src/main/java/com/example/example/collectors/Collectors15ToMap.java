package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors15ToMap {
    record Employee(String name, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 120_000),
                new Employee("Ravi", 105_000),
                new Employee("Mina", 95_000));

        Map<String, Integer> salaryByName = employees.stream()
                .collect(Collectors.toMap(Employee::name, Employee::salary));

        System.out.println("Asha salary = " + salaryByName.get("Asha"));
        System.out.println("number of entries = " + salaryByName.size());
    }
}
