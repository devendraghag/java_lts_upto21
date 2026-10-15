package com.example.example.methodoverloading;

/** Rule 16: changing only parameter names does not create an overload. */
public class Rule16ParameterNamesAloneDoNotOverload {
    static int multiply(int left, int right) {
        return left * right;
    }

    // This would not compile beside multiply(int, int):
    // static int multiply(int first, int second) { return first * second; }
    // Parameter names do not form part of a method signature.

    public static void main(String[] args) {
        System.out.println(multiply(4, 5));
    }
}
