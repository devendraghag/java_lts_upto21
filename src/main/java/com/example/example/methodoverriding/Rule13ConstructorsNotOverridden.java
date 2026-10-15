package com.example.example.methodoverriding;

/** Rule 13: constructors are not inherited methods and cannot be overridden. */
public class Rule13ConstructorsNotOverridden {
    static class Parent { Parent() { System.out.println("Parent constructor"); } }
    static class Child extends Parent { Child() { System.out.println("Child constructor"); } }
    public static void main(String[] args) { new Child(); }
}
