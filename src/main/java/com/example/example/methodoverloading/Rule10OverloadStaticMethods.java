package com.example.example.methodoverloading;

/** Rule 10: static methods can be overloaded. */
public class Rule10OverloadStaticMethods {
    static int sum(int left, int right) {
        return left + right;
    }

    static double sum(double left, double right) {
        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(sum(2, 3));
        System.out.println(sum(2.5, 3.5));
    }
}
