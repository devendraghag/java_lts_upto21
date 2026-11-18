package com.example.example.patternmatchinginstanceof;

import java.util.List;

/** Level 11: safely inspect a generic collection despite type erasure. */
public class PatternMatchingInstanceof11GenericCollection {
    static String describe(Object value) {
        if (!(value instanceof List<?> items)) {
            return "Not a list";
        }

        // List<?> is allowed: Java can check the runtime List type, but not List<String>.
        // if (value instanceof List<String> strings) { } // Does not compile: generic type erased.
        for (Object item : items) {
            if (!(item instanceof String text)) {
                return "List contains a non-string item";
            }
        }

        return "List of strings with " + items.size() + " items";
    }

    public static void main(String[] args) {
        Object names = List.of("Asha", "Ravi");
        Object mixed = List.of("Java", 21);

        System.out.println(describe(names));
        System.out.println(describe(mixed));
        System.out.println(describe("not a list"));
    }
}
