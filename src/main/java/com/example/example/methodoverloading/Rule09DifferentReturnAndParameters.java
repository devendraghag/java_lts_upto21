package com.example.example.methodoverloading;

/** Rule 9: different parameters permit overloads even when return types differ too. */
public class Rule09DifferentReturnAndParameters {
    static int convert(String value) {
        return Integer.parseInt(value);
    }

    static String convert(int value) {
        return Integer.toString(value);
    }

    public static void main(String[] args) {
        int number = convert("23");
        String text = convert(23);
        System.out.println(number + " / " + text);
    }
}
