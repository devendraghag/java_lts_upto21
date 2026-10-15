package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//Method Overloading: changing no. of arguments
/**
 * Easy: Demonstrates Test Overloading1 in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Adder {
    static int add(int a, int b) {
        return a + b;
    }

//    static double add(int a, int b) {
//        return a + b;
//    }  not possible by changing return type

    static int add(int a, int b, int c) {
        return a + b + c;
    }
}

class TestOverloading1 {
    public static void main(String[] args) {
        System.out.println(Adder.add(11, 11));
        System.out.println(Adder.add(11, 11, 11));
    }
}