package com.example.example.methodoverriding;

/** Rule 9: unchecked exceptions may be added to an overriding method. */
public class Rule09UncheckedExceptions {
    static class Parent { void run() { System.out.println("Parent run"); } }
    static class Child extends Parent {
        @Override void run() { System.out.println("Child run"); throw new IllegalStateException("demo"); }
    }
    public static void main(String[] args) {
        try { new Child().run(); } catch (IllegalStateException ex) { System.out.println(ex.getMessage()); }
    }
}
