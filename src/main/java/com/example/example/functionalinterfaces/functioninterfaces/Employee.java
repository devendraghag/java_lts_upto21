package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Employee in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

class BiFunction3 {
    public static void main(String[] args) {

        // Uses constructor reference with two parameters
        BiFunction<String, Integer, Employee> empFactory =
                Employee::new;

        Employee e = empFactory.apply("Dev", 50000);
        System.out.println(e.name + " " + e.salary);
    }
}
