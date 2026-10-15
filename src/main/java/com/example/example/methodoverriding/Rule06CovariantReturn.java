package com.example.example.methodoverriding;

/** Rule 6: an override may return a subtype of the original reference return type. */
public class Rule06CovariantReturn {
    static class Animal { }
    static class Cat extends Animal { }
    static class Parent { Animal pet() { return new Animal(); } }
    static class Child extends Parent { @Override Cat pet() { return new Cat(); } }
    public static void main(String[] args) { System.out.println(new Child().pet().getClass().getSimpleName()); }
}
