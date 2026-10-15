package com.example.example.methodoverloading;

/** Rule 1: methods can be overloaded by changing the number of parameters. */
public class Rule01DifferentParameterCount {
    static String describe(int number) {
        return "one parameter: " + number;
    }

    static String describe(int number, String label) {
        return label + ": " + number;
    }

    public static void main(String[] args) {
        System.out.println(describe(7));
        System.out.println(describe(7, "count"));
    }
}
