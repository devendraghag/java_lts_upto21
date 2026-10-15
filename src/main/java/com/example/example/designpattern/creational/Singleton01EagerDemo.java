package com.example.designpattern.creational;

// Eager initialization: the instance is created when the class is initialized.
public class Singleton01EagerDemo {
    private static final Singleton01EagerDemo INSTANCE = new Singleton01EagerDemo();

    private Singleton01EagerDemo() { // Prevent callers from using new.
    }

    public static Singleton01EagerDemo getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01EagerDemo first = getInstance();
        Singleton01EagerDemo second = getInstance();
        System.out.println("Same object: " + (first == second));
    }
}
