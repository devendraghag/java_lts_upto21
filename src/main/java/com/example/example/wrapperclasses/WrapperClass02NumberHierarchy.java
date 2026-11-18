package com.example.example.wrapperclasses;

/** Numeric wrappers extend Number; Boolean and Character do not. */
public class WrapperClass02NumberHierarchy {
    public static void main(String[] args) {
        Number integer = Integer.valueOf(12);
        Number decimal = Double.valueOf(12.75);

        System.out.println("Integer is a Number: " + (integer instanceof Number));
        System.out.println("Double is a Number: " + (decimal instanceof Number));
    }
}
