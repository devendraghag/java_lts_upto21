package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors14PartitioningBy {
    record Employee(String name, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 120_000),
                new Employee("Ravi", 95_000),
                new Employee("Mina", 110_000));

        // partitioningBy always creates the true and false predicate groups.
        Map<Boolean, List<String>> namesBySalaryBand = employees.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.salary() >= 100_000,
                        Collectors.mapping(Employee::name, Collectors.toList())));

        System.out.println(namesBySalaryBand);
    }
}
