package com.example.of.list;

import java.util.List;

/** Shows that List.of() rejects null elements. */
public class ListOf03NullValuesDemo {
    public static void main(String[] args) {
        // A null element is not allowed; List.of() throws NullPointerException.
        try {
            List<String> names = List.of("Asha", null, "Ravi");
            System.out.println(names); // This line is not reached.
        } catch (NullPointerException exception) {
            System.out.println("List.of() does not allow null elements.");
        }

        // Use a collection implementation such as ArrayList when null elements
        // are required (though allowing nulls is usually best avoided).
    }
}
