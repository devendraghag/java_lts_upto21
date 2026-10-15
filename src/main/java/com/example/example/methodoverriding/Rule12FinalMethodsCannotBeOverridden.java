package com.example.example.methodoverriding;

/** Rule 12: a final instance method cannot be overridden. */
public class Rule12FinalMethodsCannotBeOverridden {
    static class Parent { final void fixed() { System.out.println("Fixed implementation"); } }
    static class Child extends Parent { /* fixed() cannot be overridden here. */ }
    public static void main(String[] args) { new Child().fixed(); }
}
