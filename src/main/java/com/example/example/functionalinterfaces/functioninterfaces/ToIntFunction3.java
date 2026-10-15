package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToIntFunction;

/**
 * Easy: Demonstrates To Int Function3 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Employee1 {
    int salary;
    Employee1(int salary) { this.salary = salary; }
}

class ToIntFunction3 {
    public static void main(String[] args) {
        // Extract primitive field
        ToIntFunction<Employee1> getSalary = e -> e.salary;
        System.out.println(getSalary.applyAsInt(new Employee1(50000)));
    }
}