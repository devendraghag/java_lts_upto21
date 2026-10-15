package com.example.example.methodoverloading;

/** Rule 3: changing the order of different parameter types creates an overload. */
public class Rule03DifferentParameterOrder {
    static String format(String text, int count) {
        return text + " x " + count;
    }

    static String format(int count, String text) {
        return count + " x " + text;
    }

    public static void main(String[] args) {
        System.out.println(format("apple", 3));
        System.out.println(format(3, "apple"));
    }
}
