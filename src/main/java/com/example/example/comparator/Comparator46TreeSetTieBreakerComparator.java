package com.example.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class Comparator46TreeSetTieBreakerComparator {
    record Employee(String name, int salary) {}

    public static void main(String[] args) {
        // Adding name as a tie-breaker makes same-salary employees compare differently.
        Comparator<Employee> salaryThenName = Comparator
                .comparingInt(Employee::salary)
                .thenComparing(Employee::name);
        TreeSet<Employee> employees = new TreeSet<>(salaryThenName);
        employees.add(new Employee("Ada", 100));
        employees.add(new Employee("Grace", 100));
        System.out.println("size = " + employees.size());
        System.out.println(employees);
    }
}
