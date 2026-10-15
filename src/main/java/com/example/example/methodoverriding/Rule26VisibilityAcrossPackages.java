package com.example.example.methodoverriding;

/** Rule 26: an override of a public method must remain public. */
public class Rule26VisibilityAcrossPackages {
    static class Parent { public void act() { System.out.println("Parent action"); } }
    static class Child extends Parent { @Override public void act() { System.out.println("Child action"); } }
    public static void main(String[] args) { Parent p = new Child(); p.act(); }
}
