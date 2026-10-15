package com.example.example.methodoverriding;

/** Rule 2: @Override asks the compiler to verify that a method is actually overridden. */
public class Rule02OverrideAnnotation {
    static class Parent { void greet() { System.out.println("Hello"); } }
    static class Child extends Parent {
        @Override void greet() { System.out.println("Hello from Child"); }
    }
    public static void main(String[] args) { new Child().greet(); }
}
