package com.example.comparable;
import java.util.*;
public class Comparable07PersonByAge {
    record Person(String name, int age) implements Comparable<Person> {
        public int compareTo(Person o) {
            return Integer.compare(age, o.age);
        }
    }

    public static void main(String[] x) {
        System.out.println(List.of(new Person("Ravi", 41), new Person("Leena", 28)).stream().sorted().toList());
    }
}