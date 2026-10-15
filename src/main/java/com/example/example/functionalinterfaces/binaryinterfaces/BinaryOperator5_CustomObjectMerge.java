package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BinaryOperator;

/*
 BinaryOperator5: Merge two custom objects
*/
/**
 * Easy: Demonstrates Binary Operator5 Custom Object Merge in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Employee {
    int salary;
    Employee(int salary) {
        this.salary = salary;
    }
}

public class BinaryOperator5_CustomObjectMerge {
    public static void main(String[] args) {
        BinaryOperator<Employee> mergeSalary =
            (e1, e2) -> new Employee(e1.salary + e2.salary);

        Employee e = mergeSalary.apply(new Employee(1000), new Employee(2000));
        System.out.println(e.salary);
    }
}
