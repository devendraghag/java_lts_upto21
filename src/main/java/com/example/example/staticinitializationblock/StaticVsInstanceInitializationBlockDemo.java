package com.example.staticinitializationblock;

/** Contrasts a static block, which runs once, with an instance block, which runs per object. */
public class StaticVsInstanceInitializationBlockDemo {
    private static int nextId;
    private final int id;

    static {
        System.out.println("Static initialization block runs once for the class");
    }

    {
        id = ++nextId;
        System.out.println("Instance initialization block for object " + id);
    }

    private StaticVsInstanceInitializationBlockDemo() {
        System.out.println("Constructor for object " + id);
    }

    public static void main(String[] args) {
        new StaticVsInstanceInitializationBlockDemo();
        new StaticVsInstanceInitializationBlockDemo();
    }
}
