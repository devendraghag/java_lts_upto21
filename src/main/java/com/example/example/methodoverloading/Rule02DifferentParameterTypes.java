package com.example.example.methodoverloading;

/** Rule 2: methods can be overloaded by changing parameter types. */
public class Rule02DifferentParameterTypes {
    static String show(int value) {
        return "int: " + value;
    }

    static String show(String value) {
        return "String: " + value;
    }

    public static void main(String[] args) {
        System.out.println(show(42));
        System.out.println(show("hello"));
    }
}
