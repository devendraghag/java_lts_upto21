package com.example.example.methodoverriding;

/** Rule 24: synchronized is not part of the method signature and need not be repeated. */
public class Rule24SynchronizedModifier {
    static class Parent { synchronized void update() { System.out.println("Parent update"); } }
    static class Child extends Parent { @Override void update() { System.out.println("Child update"); } }
    public static void main(String[] args) { new Child().update(); }
}
