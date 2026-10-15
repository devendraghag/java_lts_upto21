package com.example.intermediateoperations;

import java.util.List;
import java.util.stream.Collectors;

/** Harder: flatten nested skills, normalize them, deduplicate, sort, and collect. */
public class IntermediatePractice13FlattenSkillsAndCollect {
    record Employee(String name, List<String> skills) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", List.of("Java", "SQL")),
                new Employee("Dev", List.of("Java", "Docker")),
                new Employee("Mina", List.of("Python", "SQL")));
        String skills = employees.stream()
                .flatMap(employee -> employee.skills().stream())
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(skills);
    }
}