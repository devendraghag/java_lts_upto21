package com.example.example.methodoverriding;

/** Rule 17: a concrete subclass must implement inherited abstract methods. */
public class Rule17AbstractMethodImplementation {
    static abstract class Parent { abstract String identify(); }
    static class Child extends Parent { @Override String identify() { return "Concrete child"; } }
    public static void main(String[] args) { System.out.println(new Child().identify()); }
}
