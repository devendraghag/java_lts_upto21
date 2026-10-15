package com.example.callbyvalue;

/** Demonstrates that a primitive argument is passed as a copied value. */
public class PrimitiveValueDemo {
    private static void changeNumber(int number) {
        number = 99;
        System.out.println("Inside method: " + number);
    }

    public static void main(String[] args) {
        int original = 10;
        changeNumber(original);
        System.out.println("After method: " + original);
    }
}
