package com.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Collectors17ToMapMapSupplier {
    record Employee(String name, int id) { }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Mina", 3),
                new Employee("Asha", 1),
                new Employee("Ravi", 2));

        // The fourth argument supplies the desired map implementation.
        Map<String, Integer> idsByName = employees.stream()
                .collect(Collectors.toMap(
                        Employee::name,
                        Employee::id,
                        (first, second) -> first,
                        TreeMap::new));

        System.out.println("key order = " + idsByName.keySet());
    }
}
