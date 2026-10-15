package com.example.example.methodoverloading;

import java.util.List;

/** Rule 17: generic type arguments alone cannot overload methods because of type erasure. */
public class Rule17GenericTypeArgumentsErase {
    static String first(List<String> values) {
        return values.isEmpty() ? "empty" : values.get(0);
    }

    // This would not compile beside first(List<String>):
    // static Integer first(List<Integer> values) { return values.get(0); }
    // Both parameter types erase to List at compile time.

    public static void main(String[] args) {
        System.out.println(first(List.of("Java", "overloading")));
    }
}
