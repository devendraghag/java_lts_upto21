package com.example.association;

import java.util.ArrayList;
import java.util.List;

/** Demonstrates a bidirectional one-to-many association. */
public class OneToManyAssociationDemo {
    private static final class Department {
        private final String name;
        private final List<Employee> employees = new ArrayList<>();

        private Department(String name) {
            this.name = name;
        }

        private void addEmployee(Employee employee) {
            employees.add(employee);
            employee.department = this;
        }
    }

    private static final class Employee {
        private final String name;
        private Department department;

        private Employee(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Department department = new Department("Engineering");
        Employee first = new Employee("Ravi");
        Employee second = new Employee("Maya");
        department.addEmployee(first);
        department.addEmployee(second);

        System.out.println(department.name + " has " + department.employees.size() + " employees");
        System.out.println(first.name + " works in " + first.department.name);
    }
}
