package com.example.example.recordpatterns;

/** Level 9: Java 21 infers record-pattern component types from a generic record selector. */
public class RecordPattern09GenericInference {
    record Pair<A, B>(A first, B second) { }

    static String describe(Pair<String, Integer> pair) {
        return switch (pair) {
            // Inferred component types: first is String; second is Integer.
            case Pair(var first, var second) -> first.toUpperCase() + " × " + second;
        };
    }

    public static void main(String[] args) {
        var pair = new Pair<>("Notebook", 3);
        System.out.println(describe(pair)); // NOTEBOOK × 3
    }
}
