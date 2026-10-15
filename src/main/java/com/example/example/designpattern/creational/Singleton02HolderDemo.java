package com.example.designpattern.creational;

// Initialization-on-demand holder: lazy, thread-safe, and does not lock each call.
public class Singleton02HolderDemo {
    private Singleton02HolderDemo() { // Only the enclosing class can construct this object.
    }

    private static class InstanceHolder {
        // The JVM initializes this nested class on its first use.
        private static final Singleton02HolderDemo INSTANCE = new Singleton02HolderDemo();
    }

    public static Singleton02HolderDemo getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(getInstance() == getInstance());
    }
}
