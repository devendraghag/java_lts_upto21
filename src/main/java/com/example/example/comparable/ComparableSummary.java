package com.example.comparable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * JDK 21 Comparable quick reference.
 *
 * Comparable<T> describes a type's default (natural) order.
 * int compareTo(T other): negative = this comes before other, zero = tied in natural order,
 * positive = this comes after other. Depend on the sign, not a particular magnitude.
 *
 * A multi-field implementation compares the primary key first. If it ties (result == 0),
 * compare the next key; return the final result. Use Integer.compare/Long.compare/
 * Double.compare rather than subtraction to avoid overflow and numeric edge cases.
 *
 * Contract: sign symmetry, transitivity, and consistent comparison to a third value.
 * compareTo returning zero is recommended to agree with equals, but it is not required;
 * sorted sets/maps treat compareTo zero as the same ordering key.
 *
 * Memory rules:
 * No comparator supplied -> natural ordering -> Comparable.compareTo()
 * stream.sorted() -> Comparable.compareTo()
 * list.sort(null), Collections.sort(list), Arrays.sort(objects) -> natural ordering
 * TreeSet / TreeMap / PriorityQueue without comparator -> natural ordering
 * Comparable is the default order; Comparator supplies an alternative order.
 *
 * Method references can be used around natural sorting: sorted() establishes order,
 * then map(Student::name) extracts a field and forEach(System.out::println) prints it.
 */
public class ComparableSummary {
    record Student(int id, String name) implements Comparable<Student> {
        public int compareTo(Student other) {
            return Integer.compare(id, other.id);
        }
    }

    record Version(int major, int minor, int patch) implements Comparable<Version> {
        public int compareTo(Version other) {
            int result = Integer.compare(major, other.major);
            if (result == 0) result = Integer.compare(minor, other.minor);
            if (result == 0) result = Integer.compare(patch, other.patch);
            return result;
        }

        public String toString() { return major + "." + minor + "." + patch; }
    }

    static <T extends Comparable<? super T>> T min(T a, T b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    static <T extends Comparable<? super T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(9, 2, 5);
        System.out.println("compare(2, 9) sign = " + Integer.signum(Integer.valueOf(2).compareTo(9)));
        System.out.println("natural stream sort = " + numbers.stream().sorted().toList());
        System.out.println("generic min/max = " + min(3, 8) + " / " + max("ant", "bee"));

        List<Student> students = List.of(new Student(2, "Mira"), new Student(1, "Asha"));
        students.stream().sorted().map(Student::name).forEach(System.out::println);

        List<Version> versions = List.of(new Version(2, 1, 0), new Version(1, 9, 8));
        System.out.println("versions = " + versions.stream().sorted().map(Version::toString).toList());

        TreeSet<String> words = new TreeSet<>(List.of("pear", "apple", "plum"));
        TreeMap<Integer, String> naturalKeys = new TreeMap<>();
        naturalKeys.put(2, "two");
        naturalKeys.put(1, "one");
        PriorityQueue<Integer> queue = new PriorityQueue<>(numbers);
        System.out.println("TreeSet = " + words + ", TreeMap = " + naturalKeys + ", queue head = " + queue.peek());

        Integer[] array = {4, 1, 3};
        Arrays.sort(array);
        System.out.println("Arrays.sort = " + Arrays.toString(array));

        BigDecimal scaledA = new BigDecimal("2.0");
        BigDecimal scaledB = new BigDecimal("2.00");
        System.out.println("BigDecimal compareTo / equals = "
                + scaledA.compareTo(scaledB) + " / " + scaledA.equals(scaledB));
        System.out.println("LocalDate natural order = "
                + List.of(LocalDate.of(2026, 12, 1), LocalDate.of(2026, 1, 1)).stream().sorted().toList());

        // Comparator is an alternative ordering for a particular operation; it does not replace compareTo.
        System.out.println("custom student name order = "
                + students.stream().sorted(Comparator.comparing(Student::name)).toList());
    }
}
