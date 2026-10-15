package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator68ConditionalComparatorBuilder {
    record Employee(String department, String name, int salary, long employeeNumber) {}

    private static Comparator<Employee> buildOrder(
            boolean byDepartment, boolean highSalaryFirst) {
        Comparator<Employee> order = byDepartment
                ? Comparator.comparing(Employee::department)
                : Comparator.comparing(Employee::name);

        if (highSalaryFirst) {
            // thenComparing adds salary only after the selected primary key ties.
            order = order.thenComparing(
                    Comparator.comparingInt(Employee::salary).reversed());
        }
        if (byDepartment) {
            order = order.thenComparing(Employee::name);
        }
        return order.thenComparingLong(Employee::employeeNumber);
    }

    private static List<Employee> sortedCopy(
            List<Employee> employees, Comparator<? super Employee> order) {
        return employees.stream().sorted(order).toList();
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("IT", "Zoe", 120, 9L),
                new Employee("IT", "Asha", 100, 3L),
                new Employee("HR", "Mira", 110, 4L));
        Comparator<Employee> requested = buildOrder(true, true);
        System.out.println(sortedCopy(employees, requested));
    }
}
