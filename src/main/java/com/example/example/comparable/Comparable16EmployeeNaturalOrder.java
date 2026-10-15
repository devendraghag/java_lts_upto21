package com.example.comparable;

import java.util.*;

public class Comparable16EmployeeNaturalOrder {
    record Employee(String department, int id, String name) implements Comparable<Employee> {
        public int compareTo(Employee o) {
            int r = department.compareTo(o.department);
            if (r == 0) r = Integer.compare(id, o.id);
            if (r == 0) r = name.compareTo(o.name);
            return r;
        }
    }

    public static void main(String[] x) {
        List<Employee> e = List.of(
                new Employee("IT", 4, "Zoe"),
                new Employee("HR", 2, "Mina"),
                new Employee("IT", 1, "Asha"));
        e.sort(null);
        System.out.println(e);
        // Department, id, then name is the declared natural order.
    }
}
