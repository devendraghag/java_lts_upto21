package com.example.example.patternmatchingforswitch;

/** Level 15: let Java infer generic record-pattern component types from the selector. */
public class PatternSwitch15GenericRecordPattern {
    record Pair<A, B>(A first, B second) { }

    static String describe(Pair<String, Integer> pair) {
        return switch (pair) {
            // Java infers name as String and quantity as Integer.
            case Pair(var name, var quantity) -> name + " × " + quantity;
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Pair<>("Notebook", 3)));
    }
}
