package com.example.example.methodoverriding;

/** Rule 23: a parameterized subclass may override using the matching type parameter. */
public class Rule23GenericTypeOverride {
    static class Parent<T> { T identity(T value) { return value; } }
    static class Child extends Parent<String> {
        @Override String identity(String value) { return value.toUpperCase(); }
    }
    public static void main(String[] args) { System.out.println(new Child().identity("java")); }
}
