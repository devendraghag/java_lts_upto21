package com.example.example.methodoverloading;

import java.io.IOException;

/** Rule 8: changing only the declared checked exception does not create an overload. */
public class Rule08ThrowsAloneDoesNotOverload {
    static void load(String name) throws IOException {
        System.out.println("Loading " + name);
    }

    // This would not compile beside load(String):
    // static void load(String name) throws ReflectiveOperationException { }
    // The throws clause is not part of the method signature.

    public static void main(String[] args) throws IOException {
        load("data");
    }
}
