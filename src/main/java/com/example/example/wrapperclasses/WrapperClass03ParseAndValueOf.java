package com.example.example.wrapperclasses;

/** parse methods return primitives; valueOf methods return wrapper objects. */
public class WrapperClass03ParseAndValueOf {
    public static void main(String[] args) {
        int primitive = Integer.parseInt("123");
        Integer wrapper = Integer.valueOf("123");
        double primitiveDecimal = Double.parseDouble("4.75");
        Double wrapperDecimal = Double.valueOf("4.75");

        System.out.println("parseInt returns int: " + primitive);
        System.out.println("valueOf returns Integer: " + wrapper);
        System.out.println("parseDouble returns double: " + primitiveDecimal);
        System.out.println("valueOf returns Double: " + wrapperDecimal);
    }
}
