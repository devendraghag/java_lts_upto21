package com.example.example.methodoverriding;

/** Rule 10: private methods are not inherited, so a same-named child method is separate. */
public class Rule10PrivateMethodsNotOverridden {
    static class Parent { private void message() { System.out.println("Parent private"); } void callParent() { message(); } }
    static class Child extends Parent { void message() { System.out.println("Child method"); } }
    public static void main(String[] args) { Child c = new Child(); c.callParent(); c.message(); }
}
