package com.example.designpattern.creational;

// Static initialization block: class initialization creates this instance once.
public class Singleton02StaticBlockInitialization {
    private static final Singleton02StaticBlockInitialization INSTANCE;

    static {
        System.out.println("Static initialization block runs once for this class loader");
        INSTANCE = new Singleton02StaticBlockInitialization();
    }

    private Singleton02StaticBlockInitialization() { }

    public static Singleton02StaticBlockInitialization getInstance() { return INSTANCE; }

    public static void main(String[] args) {
        Singleton02StaticBlockInitialization first = getInstance();
        Singleton02StaticBlockInitialization second = getInstance();
        System.out.println("Same object: " + (first == second));
    }
}
