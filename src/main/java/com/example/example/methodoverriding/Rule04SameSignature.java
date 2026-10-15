package com.example.example.methodoverriding;

/** Rule 4: an override has the same method name and parameter types. */
public class Rule04SameSignature {
    static class Parent { void print(int value) { System.out.println("Parent " + value); } }
    static class Child extends Parent {
        @Override void print(int value) { System.out.println("Child " + value); }
    }
    public static void main(String[] args) { new Child().print(4); }
}
