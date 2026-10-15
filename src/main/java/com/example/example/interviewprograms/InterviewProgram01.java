package com.example.interviewprograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private  double salary;
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    // Formats an employee so a method reference can display both values.
    public String getNameAndSalary() {
        return name + " - " + salary;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
public class InterviewProgram01
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Alex",2000));
        employees.add(new Employee(2,"Bob",31000));
        employees.add(new Employee(3,"David",4000));
        employees.add(new Employee(4,"David",5000));
        employees.add(new Employee(5,"David",6000));

        // Lambda: filter employees and format each name with its salary.
        List<String> employeeNames = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .map(employee -> employee.getNameAndSalary())
                .collect(Collectors.toList());
        System.out.println("Employees with salary above 1000: ");
        System.out.println(employeeNames);

        // Method reference alternative for map: Employee::getNameAndSalary.
        List<String> employeeNamesWithMethodReference = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .map(Employee::getNameAndSalary)
                .collect(Collectors.toList());
        System.out.println("Same result using a method reference: ");
        System.out.println(employeeNamesWithMethodReference);

        // Lambda comparator: sort from lowest to highest salary.
        List<String> asending = employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()))
                .map(employee -> employee.getNameAndSalary())
                .collect(Collectors.toList());

        System.out.println("Employees sorted by salary ascending: ");
        System.out.println(asending);

        // Method reference alternative for the comparator and the formatting map.
        List<String> ascendingWithMethodReference = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getNameAndSalary)
                .collect(Collectors.toList());
        System.out.println("Ascending using method references: ");
        System.out.println(ascendingWithMethodReference);

        // Lambda comparator, reversed to sort from highest to lowest salary.
        List<String> descendingNew = employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()).reversed())
                .map(employee -> employee.getNameAndSalary())
                .collect(Collectors.toList());

        System.out.println("Employees sorted by salary descending: ");
        System.out.println(descendingNew);

        // Method reference alternative for descending sort and formatting.
        List<String> descendingWithMethodReference = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getNameAndSalary)
                .collect(Collectors.toList());
        System.out.println("Descending using method references: ");
        System.out.println(descendingWithMethodReference);

        // Top 3 with lambdas for sorting and printing.
        System.out.println("Top 3 employees by salary (lambda): ");
        employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary())
                        .reversed())
                .limit(3)
                .forEach(employee -> System.out.println(employee.getNameAndSalary()));

        // Equivalent top 3 pipeline using method references where possible.
        System.out.println("Top 3 employees by salary (method reference): ");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getNameAndSalary)
                .forEach(System.out::println);

        // The examples below do not call getNameAndSalary().
        // A lambda can combine the name and salary directly.
        List<String> employeeNamesWithoutHelper = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .map(employee -> employee.getName() + " - " + employee.getSalary())
                .collect(Collectors.toList());
        System.out.println("Name and salary with a lambda (no helper method):");
        employeeNamesWithoutHelper.forEach(System.out::println);

        // Method reference without the helper: toString() includes name and salary (and id).
        List<String> employeeDetailsWithMethodReference = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .map(Employee::toString)
                .collect(Collectors.toList());
        System.out.println("Employee details with method reference (no helper method):");
        employeeDetailsWithMethodReference.forEach(System.out::println);

        // Sort ascending with a lambda comparator, then format with a lambda.
        List<String> ascendingWithoutHelperLambda = employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()))
                .map(employee -> employee.getName() + " - " + employee.getSalary())
                .collect(Collectors.toList());
        System.out.println("Ascending with lambdas (no helper method):");
        ascendingWithoutHelperLambda.forEach(System.out::println);

        // Sort and convert to the existing toString() representation with method references.
        List<String> ascendingWithoutHelperMethodReference = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::toString)
                .collect(Collectors.toList());
        System.out.println("Ascending with method references (no helper method):");
        ascendingWithoutHelperMethodReference.forEach(System.out::println);

        // Sort descending with a lambda comparator and format with a lambda.
        List<String> descendingWithoutHelperLambda = employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()).reversed())
                .map(employee -> employee.getName() + " - " + employee.getSalary())
                .collect(Collectors.toList());
        System.out.println("Descending with lambdas (no helper method):");
        descendingWithoutHelperLambda.forEach(System.out::println);

        // Sort and convert to toString() with method references.
        List<String> descendingWithoutHelperMethodReference = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::toString)
                .collect(Collectors.toList());
        System.out.println("Descending with method references (no helper method):");
        descendingWithoutHelperMethodReference.forEach(System.out::println);

        // Top three with a lambda comparator and direct name/salary formatting.
        System.out.println("Top 3 with lambdas (no helper method):");
        employees.stream()
                .sorted(Comparator.comparingDouble((Employee employee) -> employee.getSalary()).reversed())
                .limit(3)
                .forEach(employee -> System.out.println(
                        employee.getName() + " - " + employee.getSalary()));

        // Top three with method references; toString() includes the salary.
        System.out.println("Top 3 with method references (no helper method):");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::toString)
                .forEach(System.out::println);


        Predicate<Employee> highSalary =
                emp -> emp.getSalary() > 50000;

        Predicate<Employee> startsWithP =
                emp -> emp.getName().startsWith("P");

// AND: Both conditions must be true
        long andCount = employees.stream()
                .filter(highSalary.and(startsWithP))
                .count();

// OR: At least one condition must be true
        long orCount = employees.stream()
                .filter(highSalary.or(startsWithP))
                .count();

// NOT: Reverse the salary condition
        long notCount = employees.stream()
                .filter(highSalary.negate())
                .count();

        System.out.println("AND: " + andCount);
        System.out.println("OR: " + orCount);
        System.out.println("NOT: " + notCount);
    }
}
