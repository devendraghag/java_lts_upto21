package com.example.datatypes;

/** Demonstrates all eight Java primitive types and common literal forms. */
public class PrimitiveTypesDemo {
    public static void main(String[] args) {
        byte smallInteger = 120;
        short mediumInteger = 30_000;
        int integer = 0b0010_1010;       // Binary literal: 42.
        long largeInteger = 9_000_000_000L;

        float singlePrecision = 3.14F;
        double doublePrecision = 3.141592653589793;

        char letter = 'J';
        boolean isJavaFun = true;

        System.out.println("byte: " + smallInteger + " (" + Byte.MIN_VALUE
                + " to " + Byte.MAX_VALUE + ")");
        System.out.println("short: " + mediumInteger);
        System.out.println("int: " + integer + " (" + Integer.MIN_VALUE
                + " to " + Integer.MAX_VALUE + ")");
        System.out.println("long: " + largeInteger);
        System.out.println("float: " + singlePrecision);
        System.out.println("double: " + doublePrecision);
        System.out.println("char: " + letter + " (numeric value " + (int) letter + ")");
        System.out.println("boolean: " + isJavaFun);

        char omega = '\u03A9';
        String globe = "🌍";
        System.out.println("Unicode char: " + omega);
        System.out.println("A supplementary Unicode code point: "
                + globe + " = U+" + Integer.toHexString(globe.codePointAt(0)).toUpperCase());

        int wrapped = Integer.MAX_VALUE + 1;
        System.out.println("int overflow wraps to: " + wrapped);
    }
}
