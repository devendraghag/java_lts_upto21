package com.example.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


// Bad use case: mutable object
/**
 * Easy: Demonstrates Record02 Mutable Class Contrast in the Records topic.
 * Use this type with its related example to observe the basic behavior.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
class MutableUser {
    String name;
    void setName(String name) {
        this.name = name;
    }
}
