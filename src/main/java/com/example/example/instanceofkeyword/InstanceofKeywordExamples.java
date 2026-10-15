package com.example.instanceofkeyword;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Java instanceof checks and pattern matching through JDK 21.
 * Pattern matching for instanceof became a permanent feature in JDK 16.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/instanceofkeyword/InstanceofKeywordExamples.java
 *   java -cp out com.example.instanceofkeyword.InstanceofKeywordExamples
 */
public class InstanceofKeywordExamples {
    public static void main(String[] args) {
        traditionalTypeCheckAndCast();
        patternMatchingForInstanceof();
        flowScopedPatternVariables();
        classInterfaceAndArrayChecks();
        nullAndGenericTypeChecks();
    }

    private static void traditionalTypeCheckAndCast() {
        System.out.println("== Traditional instanceof check and cast ==");

        Object value = "Java";
        if (value instanceof String) {
            String text = (String) value; // cast after confirming the runtime type
            System.out.println("String length: " + text.length());
        }
    }

    private static void patternMatchingForInstanceof() {
        System.out.println("\n== Pattern matching for instanceof (JDK 16+) ==");

        Object value = "Java 21";
        if (value instanceof String text) {
            // The check and cast are combined; text has type String in this branch.
            System.out.println("Uppercase: " + text.toUpperCase());
        }

        Object other = 42;
        if (other instanceof String text) {
            System.out.println(text); // not executed
        } else {
            System.out.println("Integer is not a String");
        }
    }

    private static void flowScopedPatternVariables() {
        System.out.println("\n== Flow-scoped pattern variables ==");

        Object value = "pattern";
        if (value instanceof String text && !text.isEmpty()) {
            // text is in scope on the right side of && and inside this branch.
            System.out.println("Non-empty string: " + text);
        }

        if (!(value instanceof String text)) {
            System.out.println("Not a string; return early");
            return;
        }
        // Because the if branch exits, the compiler knows value matched String here.
        System.out.println("After the guard: " + text.toUpperCase());
    }

    private static void classInterfaceAndArrayChecks() {
        System.out.println("\n== Check classes, superclasses, interfaces, and arrays ==");

        Object dog = new Dog();
        System.out.println("Dog instance: " + (dog instanceof Dog));
        System.out.println("Animal superclass: " + (dog instanceof Animal));
        System.out.println("Runnable interface: " + (dog instanceof Runnable));

        if (dog instanceof Runnable runnable) {
            runnable.run();
        }

        Object array = new String[] {"one", "two"};
        if (array instanceof String[] strings) {
            System.out.println("String array length: " + strings.length);
        }
    }

    private static void nullAndGenericTypeChecks() {
        System.out.println("\n== Null and generic type checks ==");

        Object possiblyNull = null;
        System.out.println("null instanceof String: " + (possiblyNull instanceof String));
        if (possiblyNull instanceof String text) {
            System.out.println(text); // null never matches, so this branch is not entered
        }

        Object values = new ArrayList<>(List.of("a", "b"));
        if (values instanceof List<?> list) {
            // A wildcard type is reifiable enough for a runtime check; elements are Objects.
            System.out.println("List<?> size: " + list.size());
        }

        // Due to type erasure, this is not allowed:
        // if (values instanceof List<String> strings) { ... }
        // The runtime can check List, but cannot determine its element type argument.
    }

    private static class Animal { }

    private static final class Dog extends Animal implements Runnable {
        @Override
        public void run() {
            System.out.println("Dog runs");
        }
    }
}
