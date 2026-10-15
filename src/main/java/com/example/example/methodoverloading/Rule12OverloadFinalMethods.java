package com.example.example.methodoverloading;

/** Rule 12: final methods can be overloaded. */
public class Rule12OverloadFinalMethods {
    final String describe(int value) {
        return "integer " + value;
    }

    final String describe(boolean value) {
        return "boolean " + value;
    }

    public static void main(String[] args) {
        Rule12OverloadFinalMethods example = new Rule12OverloadFinalMethods();
        System.out.println(example.describe(1));
        System.out.println(example.describe(true));
    }
}
