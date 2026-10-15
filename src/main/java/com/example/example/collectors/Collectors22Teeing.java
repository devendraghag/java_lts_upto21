package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors22Teeing {
    record Employee(String name, int salary) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", 120_000),
                new Employee("Ravi", 105_000),
                new Employee("Mina", 95_000));

        // teeing runs two collectors over the same elements, then combines their results.
        double averageSalary = employees.stream().collect(Collectors.teeing(
                Collectors.summingInt(Employee::salary),
                Collectors.counting(),
                (total, count) -> total / (double) count));

        System.out.println("average salary = " + averageSalary);
    }
}
