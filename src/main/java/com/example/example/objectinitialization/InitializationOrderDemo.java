package com.example.objectinitialization;

/** Demonstrates superclass, field, instance-block, and constructor initialization order. */
public class InitializationOrderDemo {
    private static class Parent {
        static {
            System.out.println("Parent static initialization");
        }

        private String parentField = announce("Parent field initializer");

        {
            System.out.println("Parent instance initializer");
        }

        private Parent() {
            System.out.println("Parent constructor");
        }
    }

    private static final class Child extends Parent {
        static {
            System.out.println("Child static initialization");
        }

        private String childField = announce("Child field initializer");

        {
            System.out.println("Child instance initializer");
        }

        private Child() {
            System.out.println("Child constructor");
        }
    }

    private static String announce(String message) {
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) {
        System.out.println("First object:");
        new Child();
        System.out.println("Second object:");
        new Child();
    }
}
