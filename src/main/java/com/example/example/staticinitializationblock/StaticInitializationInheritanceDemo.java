package com.example.staticinitializationblock;

/** Demonstrates superclass static initialization before subclass static initialization. */
public class StaticInitializationInheritanceDemo {
    private static class Parent {
        static {
            System.out.println("Parent static block");
        }
    }

    private static final class Child extends Parent {
        static {
            System.out.println("Child static block");
        }

        private static void start() {
            System.out.println("Child static method");
        }
    }

    public static void main(String[] args) {
        System.out.println("Before active use");
        Child.start();
    }
}
