package com.example.example.methodoverloading;

/** Rule 4: a return-type-only change is not a valid overload. */
public class Rule04ReturnTypeAloneDoesNotOverload {
    static String convert(int value) {
        return "value=" + value;
    }

    // This would not compile beside convert(int):
    // static int convert(int value) {
    // return value;
    // }
    // Both declarations have the same name and parameter list.

    public static void main(String[] args) {
        System.out.println(convert(12));
    }
}
