package com.example.example.methodoverriding;

/** Rule 27: an override may narrow a reference return type to a subtype. */
public class Rule27ReturnTypeCannotWiden {
    static class Animal { }
    static class Cat extends Animal { }
    static class Parent { Animal pet() { return new Animal(); } }
    static class Child extends Parent { @Override Cat pet() { return new Cat(); } }
    public static void main(String[] args) { System.out.println(new Child().pet().getClass().getSimpleName()); }
}
