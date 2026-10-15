package com.example.autoboxingunboxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Java autoboxing and unboxing, wrapper types, common use cases,
 * and pitfalls through JDK 21. No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/autoboxingunboxing/AutoboxingUnboxingExamples.java
 *   java -cp out com.example.autoboxingunboxing.AutoboxingUnboxingExamples
 */
public class AutoboxingUnboxingExamples {
    public static void main(String[] args) {
        primitiveWrapperPairs();
        assignmentsAndMethods();
        collectionsAndOperators();
        varargsBoxing();
        wrapperEqualityAndCaching();
        nullUnboxing();
    }

    private static void primitiveWrapperPairs() {
        System.out.println("== Primitive and wrapper type pairs ==");

        boolean boxedBoolean = true;
        byte boxedByte = 1;
        short boxedShort = 2;
        char boxedChar = 'J';
        int boxedInt = 21;
        long boxedLong = 22L;
        float boxedFloat = 1.5F;
        double boxedDouble = 2.5;

        System.out.println("boolean/Boolean: " + boxedBoolean);
        System.out.println("byte/Byte: " + boxedByte);
        System.out.println("short/Short: " + boxedShort);
        System.out.println("char/Character: " + boxedChar);
        System.out.println("int/Integer: " + boxedInt);
        System.out.println("long/Long: " + boxedLong);
        System.out.println("float/Float: " + boxedFloat);
        System.out.println("double/Double: " + boxedDouble);
    }

    private static void assignmentsAndMethods() {
        System.out.println("\n== Assignment and method conversions ==");

        int primitive = 42;
        Integer wrapper = primitive; // autoboxing: int -> Integer
        int unboxed = wrapper;       // unboxing: Integer -> int
        System.out.println("primitive -> wrapper -> primitive: " + primitive + " -> " + wrapper + " -> " + unboxed);

        printInteger(primitive); // argument is boxed to Integer
        int doubled = doubleValue(wrapper); // argument and returned Integer are unboxed
        System.out.println("method result assigned to primitive: " + doubled);
    }

    private static void printInteger(Integer value) {
        System.out.println("boxed method argument: " + value);
    }

    private static Integer doubleValue(int value) {
        return value * 2; // return value is boxed to Integer
    }

    private static void collectionsAndOperators() {
        System.out.println("\n== Collections and arithmetic ==");

        // Generic type arguments must be reference types, so collections use wrappers.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10); // int boxed to Integer
        numbers.add(20);
        int total = numbers.get(0) + numbers.get(1); // both Integer values are unboxed
        System.out.println("List<Integer>: " + numbers + "; total=" + total);

        // List<int> is not legal Java; primitive values are boxed in generic collections.
        Integer count = 5;
        count++; // unboxes, adds one, then boxes the result
        System.out.println("compound update on wrapper: " + count);
    }

    private static void varargsBoxing() {
        System.out.println("\n== Varargs boxing ==");

        printAll(1, 2, 3); // each int is boxed into an Integer for Integer... values
    }

    private static void printAll(Integer... values) {
        for (Integer value : values) {
            System.out.print((value + 1) + " "); // arithmetic unboxes each Integer
        }
        System.out.println();
    }

    private static void wrapperEqualityAndCaching() {
        System.out.println("\n== Wrapper equality and value caching ==");

        Integer firstSmall = Integer.valueOf(100);
        Integer secondSmall = Integer.valueOf(100);
        Integer firstLarge = Integer.valueOf(1000);
        Integer secondLarge = Integer.valueOf(1000);

        System.out.println("small values: == " + (firstSmall == secondSmall)
                + ", equals " + firstSmall.equals(secondSmall));
        System.out.println("large values: equals " + firstLarge.equals(secondLarge));
        System.out.println("Use equals for wrapper value comparison; identity outside the guaranteed cache range is not guaranteed.");
    }

    private static void nullUnboxing() {
        System.out.println("\n== Null unboxing ==");

        Integer maybeNull = null;
        try {
            int value = maybeNull; // unboxing null throws NullPointerException
            System.out.println(value);
        } catch (NullPointerException exception) {
            System.out.println("Cannot unbox null: " + exception.getClass().getSimpleName());
        }

        int safeValue = maybeNull == null ? 0 : maybeNull;
        System.out.println("Use a null check or a default value: " + safeValue);
    }

    /*
     * Wrapper classes are immutable value-based types. Avoid relying on object
     * identity, synchronizing on wrappers, or constructing wrappers with deprecated
     * constructors. Repeated boxing can also create overhead in performance-critical
     * code; use primitives when a nullable/reference value is not needed.
     */
}
