package com.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Demonstrates common downstream and grouping collectors. */
public class Stream15CollectorsGroupingDemo {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "Engineering", 90_000),
                new Employee("Ben", "Sales", 70_000),
                new Employee("Cara", "Engineering", 105_000),
                new Employee("Dev", "Sales", 82_000));

        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));
        System.out.println("groupingBy: " + byDepartment);

        Map<Boolean, List<Employee>> bySalaryThreshold = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.salary() >= 80_000));
        System.out.println("partitioningBy (salary >= 80000): " + bySalaryThreshold);

        String names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println("joining: " + names);

        Map<String, Integer> salaryByName = employees.stream()
                .collect(Collectors.toMap(Employee::name, Employee::salary));
        System.out.println("toMap: " + salaryByName);

        List<String> immutableResult = employees.stream()
                .map(Employee::name)
                .toList();
        System.out.println("Stream.toList: " + immutableResult);

        // teeing is available since Java 12: one traversal feeds two collectors.
        String averageAndCount = employees.stream().collect(Collectors.teeing(
                Collectors.averagingInt(Employee::salary),
                Collectors.counting(),
                (average, count) -> "average=" + average + ", count=" + count));
        System.out.println("teeing: " + averageAndCount);
    }

    private record Employee(String name, String department, int salary) {
    }
}
