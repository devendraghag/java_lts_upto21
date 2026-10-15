package com.example.example.methodoverloading;

/** Rule 15: a varargs parameter can participate in overloading. */
public class Rule15OverloadVarargs {
    static String join(String first, String second) {
        return first + ", " + second;
    }

    static String join(String... values) {
        return String.join(", ", values);
    }

    public static void main(String[] args) {
        System.out.println(join("red", "blue"));
        System.out.println(join("red", "blue", "green"));
    }
}
