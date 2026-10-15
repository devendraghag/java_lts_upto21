package com.example.finalkeyword;

import java.util.ArrayList;
import java.util.List;

/** Final local variables, parameters, instance fields, and static fields. */
public class FinalVariablesDemo {
    private static final int MAX_ATTEMPTS = 3;
    private final String id; // Blank final field is assigned by each constructor.

    FinalVariablesDemo(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        final int answer = 42;
        // answer = 43; // Compile-time error: a final variable cannot be reassigned.

        final List<String> names = new ArrayList<>();
        names.add("Asha"); // The reference is final; the referenced list can still change.

        printDetails(answer, names);
        System.out.println("Limit: " + MAX_ATTEMPTS);
        System.out.println("Instance id: " + new FinalVariablesDemo("ID-1").id);
    }

    private static void printDetails(final int value, List<String> names) {
        // value = 0; // Compile-time error: final parameter cannot be reassigned.
        names.add("Ravi");
        System.out.println("Value/list: " + value + "/" + names);
    }
}
