package com.example.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Quick reference for java.util.Comparator on JDK 21.
 *
 * compare(a, b): negative means a precedes b, zero means tied by this comparator,
 * positive means a follows b. Rely on the sign, not a particular magnitude.
 *
 * Factories and composition:
 * Comparator.naturalOrder()                 built-in Comparable order
 * Comparator.reverseOrder()                 reverse built-in Comparable order
 * Comparator.comparing(Person::name)         reference key extractor
 * Comparator.comparingInt(Person::id)        int key extractor
 * Comparator.comparingLong(Employee::number) long key extractor
 * Comparator.comparingDouble(Employee::salary) double key extractor
 * comparator.thenComparing(Person::name)      reference-key tie-break
 * comparator.thenComparingInt(Person::id)     int tie-break
 * comparator.thenComparingLong(Employee::number) long tie-break
 * comparator.thenComparingDouble(Employee::score) double tie-break
 * comparator.reversed()                      reverse the comparator expression to its left
 * Comparator.nullsFirst(comparator)          null before non-null
 * Comparator.nullsLast(comparator)           null after non-null
 *
 * Functional-interface shapes:
 * Comparator<T>                (T, T) -> int
 * Function<T, U>               T -> U  (used by comparing)
 * ToIntFunction<T>             T -> int
 * ToLongFunction<T>            T -> long
 * ToDoubleFunction<T>          T -> double
 *
 * Memory rules:
 * Comparator supplied -> Comparator.compare()
 * comparing(keyExtractor) -> extract key -> compare key
 * Stream.sorted(comparator) -> stream uses comparator
 * TreeSet(comparator) -> set uses comparator for order and comparison-equivalence
 * PriorityQueue(comparator) -> queue uses comparator to choose its head
 */
public class ComparatorSummary {
    record Person(String name, int id) {}
    record Employee(String name, long number, double salary) {}

    public static void main(String[] args) {
        Comparator<Integer> ascending = Comparator.naturalOrder();
        Comparator<Integer> descending = Comparator.reverseOrder();

        System.out.println("compare sign = "
                + Integer.signum(ascending.compare(3, 7)));
        System.out.println("natural = " + List.of(9, 2, 5).stream().sorted(ascending).toList());
        System.out.println("reverse = " + List.of(9, 2, 5).stream().sorted(descending).toList());

        List<Person> people = List.of(new Person("Zoe", 2), new Person("Asha", 1));
        // Person::name has Function<Person, String> shape; Person::id has ToIntFunction<Person> shape.
        Comparator<Person> byNameThenId = Comparator.comparing(Person::name)
                .thenComparingInt(Person::id);
        System.out.println("method-reference keys = " + people.stream()
                .sorted(byNameThenId).toList());

        List<Employee> employees = List.of(
                new Employee("Bo", 2L, 80_000),
                new Employee("Asha", 1L, 95_000));
        Comparator<Employee> bySalaryThenNumber = Comparator
                .comparingDouble(Employee::salary)
                .thenComparingLong(Employee::number);
        System.out.println("double then long key = "
                + employees.stream().sorted(bySalaryThenNumber).toList());
        System.out.println("minimum = " + employees.stream()
                .min(bySalaryThenNumber).orElseThrow());
        System.out.println("maximum = " + employees.stream()
                .max(bySalaryThenNumber).orElseThrow());

        Comparator<String> nullFirst = Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER);
        System.out.println("null first = "
                + java.util.stream.Stream.of("Mira", null, "Asha").sorted(nullFirst).toList());
    }
}
