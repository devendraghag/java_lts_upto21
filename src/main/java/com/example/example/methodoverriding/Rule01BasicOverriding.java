package com.example.example.methodoverriding;

/** Rule 1: a subclass can replace an inherited instance method implementation. */
public class Rule01BasicOverriding {
    static class Animal { void speak() { System.out.println("Animal sound"); } }
    static class Dog extends Animal {
        @Override void speak() { System.out.println("Dog barks"); }
    }
    public static void main(String[] args) { new Dog().speak(); }
}
