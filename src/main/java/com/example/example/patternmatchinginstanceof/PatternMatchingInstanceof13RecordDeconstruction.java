package com.example.example.patternmatchinginstanceof;

/** Level 13: use Java 21 record patterns with instanceof to read nested record data. */
public class PatternMatchingInstanceof13RecordDeconstruction {
    record Department(String name) { }
    record Employee(String name, Department department) { }

    static String describe(Object value) {
        if (value instanceof Employee(String employeeName, Department(String departmentName))) {
            return employeeName + " works in " + departmentName;
        }
        return "Not an employee";
    }

    public static void main(String[] args) {
        Object employee = new Employee("Mina", new Department("Engineering"));
        Object other = "visitor";

        System.out.println(describe(employee));
        System.out.println(describe(other));
    }
}
