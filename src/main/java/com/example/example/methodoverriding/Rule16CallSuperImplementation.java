package com.example.example.methodoverriding;

/** Rule 16: super.method() explicitly calls the parent implementation. */
public class Rule16CallSuperImplementation {
    static class Parent { void print() { System.out.println("Parent details"); } }
    static class Child extends Parent {
        @Override void print() { super.print(); System.out.println("Additional child details"); }
    }
    public static void main(String[] args) { new Child().print(); }
}
