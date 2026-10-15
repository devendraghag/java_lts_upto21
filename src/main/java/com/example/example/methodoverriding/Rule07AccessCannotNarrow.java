package com.example.example.methodoverriding;

/** Rule 7: an overriding method cannot have more restrictive access. */
public class Rule07AccessCannotNarrow {
    static class Parent { protected void show() { System.out.println("Parent"); } }
    static class Child extends Parent { @Override public void show() { System.out.println("Child"); } }
    public static void main(String[] args) { new Child().show(); }
}
