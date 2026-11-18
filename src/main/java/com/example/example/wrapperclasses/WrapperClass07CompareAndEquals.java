package com.example.example.wrapperclasses;

/** Use equals for wrapper value equality and compare for ordering. */
public class WrapperClass07CompareAndEquals {
    public static void main(String[] args) {
        Integer first = Integer.valueOf(500);
        Integer second = Integer.valueOf(500);

        System.out.println("Same numeric value: " + first.equals(second));
        System.out.println("Ordering sign: " + Integer.signum(Integer.compare(first, 700)));
        System.out.println("== checks object identity: " + (first == second));
    }
}
