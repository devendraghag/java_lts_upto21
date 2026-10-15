package com.example.terminaloperations;

import java.util.List;
import java.util.Map;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/** Advanced: combine groupingBy and summarizingDouble for a department salary report. */
public class TerminalOperationPractice20EmployeeSalaryReport {
    record Employee(String name, String department, double salary) {
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha", "IT", 92000),
                new Employee("Dev", "IT", 108000),
                new Employee("Mina", "HR", 76000),
                new Employee("Ravi", "Finance", 99000),
                new Employee("Noor", "Finance", 112000));

        Map<String, DoubleSummaryStatistics> report = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::department,
                        Collectors.summarizingDouble(Employee::salary)));

        report.forEach((department, stats) -> System.out.printf(
                "%s: employees=%d, average=%.2f, range=%.2f..%.2f%n",
                department, stats.getCount(), stats.getAverage(), stats.getMin(), stats.getMax()));
    }
}
