package com.example.collectionclasses.stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> values = new Stack<>();
        values.push("bottom");
        values.push("middle");
        values.push("top");
        values.add("new-top"); // Stack inherits Vector's List operations.
        values.removeIf(value -> value.equals("middle"));

        System.out.println("Peek: " + values.peek());
        System.out.println("Search top (1-based): " + values.search("top"));
        for (String value : values) {
            System.out.println("Iteration, bottom to top: " + value);
        }

        System.out.println("Pop (LIFO): " + values.pop());
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        // Stack is a sequenced List in JDK 21; sequence order is bottom to top.
        System.out.println("Reverse view (top to bottom): " + values.reversed());
        values.addFirst("new-bottom");
        System.out.println("JDK 21 first / last: " + values.getFirst() + " / " + values.getLast());
    }
}
