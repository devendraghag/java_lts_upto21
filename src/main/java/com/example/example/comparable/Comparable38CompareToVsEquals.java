package com.example.comparable;

import java.util.*;

public class Comparable38CompareToVsEquals {
    record Employee(String name, int salary) implements Comparable<Employee> {
        public int compareTo(Employee o) {
            return Integer.compare(salary, o.salary);
        }
    }

    public static void main(String[] x) {
        Employee a = new Employee("Asha", 90000), b = new Employee("Dev", 90000);
        System.out.println("compareTo zero " + (a.compareTo(b) == 0));
        System.out.println("equals " + a.equals(b));
        TreeSet<Employee> set = new TreeSet<>(List.of(a, b));
        System.out.println("TreeSet size " + set.size());
        // Natural-order tie is not the same as equals; TreeSet uses compareTo zero.
    }
}
