package com.example.comparable;

import java.util.*;

public class Comparable15EmployeeMultiField {
    record Employee(String dept, double salary, String name) implements Comparable<Employee> {
        public int compareTo(Employee o) {
            int r = dept.compareTo(o.dept);
            if (r == 0) r = Double.compare(salary, o.salary);
            if (r == 0) r = name.compareTo(o.name);
            return r;
        }
    }

    public static void main(String[] x) {
        List<Employee> employees = List.of(
                new Employee("IT", 9, "Zoe"),
                new Employee("IT", 9, "Asha"),
                new Employee("HR", 8, "Mina"));
        System.out.println(employees.stream()
                .sorted()
                .toList());
    }
}
