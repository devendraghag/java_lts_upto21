package com.example.statickeyword;

/** Demonstrates that static methods are hidden rather than overridden. */
public class StaticMethodHidingDemo {
    public static void main(String[] args) {
        Parent.describe();
        Child.describe();

        Parent reference = new Child();
        reference.describe(); // Static method selection follows the reference type.
    }

    private static class Parent {
        static void describe() {
            System.out.println("Parent static method");
        }
    }

    private static final class Child extends Parent {
        static void describe() {
            System.out.println("Child static method");
        }
    }
}
