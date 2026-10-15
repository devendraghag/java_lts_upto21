package com.example.example.methodoverriding;

/** Rule 14: fields are hidden by name; field selection uses the reference type. */
public class Rule14FieldsAreHidden {
    static class Parent { String name = "Parent field"; }
    static class Child extends Parent { String name = "Child field"; }
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.name);
        System.out.println(((Child) p).name);
    }
}
