package com.example.example.methodoverriding;

/** Rule 22: a generic parent method can be overridden with the matching erased signature. */
public class Rule22GenericMethodOverride {
    static class Parent { <T> T echo(T value) { return value; } }
    static class Child extends Parent {
        @Override <T> T echo(T value) { System.out.println("Echoing " + value); return value; }
    }
    public static void main(String[] args) { System.out.println(new Child().echo("hello")); }
}
