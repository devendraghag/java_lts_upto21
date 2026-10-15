package com.example.comparable;

import java.util.*;

public class Comparable05EmployeeBySalary {
    record Employee(String name, double salary) implements Comparable<Employee> {
        public int compareTo(Employee o) {
            return Double.compare(salary, o.salary);
        }
    }

    public static void main(String[] x) {
        System.out.println(List.of(new Employee("Ira", 90000), new Employee("Dev", 70000)).stream().sorted().toList());
        // sorted invokes compareTo.
    }
}
