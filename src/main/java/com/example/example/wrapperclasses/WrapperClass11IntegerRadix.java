package com.example.example.wrapperclasses;

/** Integer parsing and formatting can use a radix such as binary or hexadecimal. */
public class WrapperClass11IntegerRadix {
    public static void main(String[] args) {
        int binaryValue = Integer.parseInt("1010", 2);
        int hexadecimalValue = Integer.parseInt("FF", 16);

        System.out.println("Binary 1010 as decimal: " + binaryValue);
        System.out.println("Hex FF as decimal: " + hexadecimalValue);
        System.out.println("42 in binary: " + Integer.toBinaryString(42));
        System.out.println("42 in hexadecimal: " + Integer.toHexString(42));
    }
}
