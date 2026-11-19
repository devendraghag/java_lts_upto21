package com.example.aggregation;

import java.util.List;

/** Multiple employees refer to one independently existing department. */
public class Aggregation02SharedDepartment {
    public static void main(String[] args) {
        Department department = new Department("Engineering");
        List<Employee> employees = List.of(new Employee("Asha", department), new Employee("Ravi", department));
        employees.forEach(Employee::introduce);
        System.out.println("Shared department: " + (employees.get(0).department == employees.get(1).department));
    }

    private static final class Department {
        private final String name;
        private Department(String name) { this.name = name; }
    }
    private static final class Employee {
        private final String name;
        private final Department department;
        private Employee(String name, Department department) { this.name = name; this.department = department; }
        private void introduce() { System.out.println(name + " works in " + department.name); }
    }
}
