package com.example.example.methodoverriding;

/** Rule 15: changing parameter types creates an overload, not an override. */
public class Rule15OverloadingIsDifferent {
    static class Parent { void show(Object value) { System.out.println("Object overload"); } }
    static class Child extends Parent { void show(String value) { System.out.println("String overload"); } }
    public static void main(String[] args) {
        Child c = new Child();
        c.show("text");
        ((Parent) c).show("text");
    }
}
