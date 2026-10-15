package com.example.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


// Record fields are final by default
/**
 * Easy: Demonstrates Record06 Immutable Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Book(String title, int pages) {}

public class Record06ImmutableDemo {
    public static void main(String[] args) {
        Book b = new Book("Java", 500);

        // b.pages = 600; ❌ COMPILATION ERROR
        // Records cannot be modified after creation

        System.out.println(b);
    }
}
