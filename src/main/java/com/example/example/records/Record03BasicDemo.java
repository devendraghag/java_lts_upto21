package com.example.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.

// A record is a transparent data holder
// Java automatically creates:
// - constructor
// - getters (called components)
// - equals, hashCode, toString

/**
 * Easy: Demonstrates Record03 Basic Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Person(String name, int age) {}

public class Record03BasicDemo {
    public static void main(String[] args) {
        Person p = new Person("Amit", 25);

        // Accessing data using component methods
        System.out.println(p.name()); // Amit
        System.out.println(p.age());  // 25

        // toString is auto-generated
        System.out.println(p); // Person[name=Amit, age=25]
    }
}
