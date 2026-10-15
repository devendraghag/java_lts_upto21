package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/*
 * JDK 1.0 introduction-version bucket interview program: method overloading.
 *
 * Interview point:
 * - Overloading is resolved at compile time by parameter list.
 */
/**
 * Easy: Demonstrates Method Overloading Interview Program in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
public class MethodOverloadingInterviewProgram {
    public static void main(String[] args) {
        CalculatorInterview calculator = new CalculatorInterview();
        check(calculator.add(1, 2) == 3, "int overload mismatch");
        check(calculator.add("a", "b").equals("ab"), "String overload mismatch");
        System.out.println(calculator.add(1, 2));
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}

class CalculatorInterview {
    int add(int left, int right) {
        return left + right;
    }

    String add(String left, String right) {
        return left + right;
    }
}
