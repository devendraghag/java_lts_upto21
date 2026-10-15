package com.example.example.methodoverloading;

/** Rule 6: static versus instance alone does not create an overload. */
public class Rule06StaticAloneDoesNotOverload {
    void execute(int value) {
        System.out.println("instance: " + value);
    }

    // This would not compile beside execute(int):
    // static void execute(int value) { System.out.println(value); }
    // The static modifier is not part of the method signature.

    public static void main(String[] args) {
        new Rule06StaticAloneDoesNotOverload().execute(6);
    }
}
