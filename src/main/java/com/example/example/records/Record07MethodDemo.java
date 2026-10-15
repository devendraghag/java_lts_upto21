package com.example.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record07 Method Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Rectangle(int length, int width) {

    // Records can have methods
    int area() {
        return length * width;
    }
}

public class Record07MethodDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        System.out.println(r.area());
    }
}
