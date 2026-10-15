package com.example.example.methodoverriding;

/** Rule 5: primitive return types must match exactly in an override. */
public class Rule05ReturnTypeMustMatch {
    static class Parent { int score() { return 10; } }
    static class Child extends Parent { @Override int score() { return 20; } }
    public static void main(String[] args) { System.out.println(new Child().score()); }
}
