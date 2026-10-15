package com.example.example.methodoverriding;

/** Rule 11: static methods are hidden, and selection depends on the reference type. */
public class Rule11StaticMethodsHidden {
    static class Parent { static void label() { System.out.println("Parent static"); } }
    static class Child extends Parent { static void label() { System.out.println("Child static"); } }
    public static void main(String[] args) { Parent p = new Child(); p.label(); Child.label(); }
}
