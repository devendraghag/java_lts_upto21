package com.example.intermediateoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/** Challenge: build a dynamic condition and safely process possibly null text values. */
public class IntermediatePractice16NullSafeDynamicPipeline {
    record Employee(String name, String department, double salary, boolean active) {}

    public static void main(String[] args) {
        List<String> raw = Arrays.asList(" Java ", null, "   ", "Streams", "");
        Predicate<String> nonBlank = Predicate.not(String::isBlank);
        List<String> clean = raw.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(nonBlank)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(clean);

        List<Employee> employees = List.of(
                new Employee("Asha", "IT", 92000, true),
                new Employee("Dev", "IT", 108000, false),
                new Employee("Mina", "HR", 76000, true));
        Predicate<Employee> condition = Employee::active;
        condition = condition.and(employee -> employee.salary() >= 80000);
        System.out.println(employees.stream().filter(condition).toList());
    }
}