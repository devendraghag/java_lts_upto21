package com.example.example.wrapperclasses;

/** Number conversion methods can lose a fractional part or overflow a smaller type. */
public class WrapperClass06Conversions {
    public static void main(String[] args) {
        Number value = Double.valueOf(130.9);

        System.out.println("As double: " + value.doubleValue());
        System.out.println("As int (fraction is discarded): " + value.intValue());
        System.out.println("As byte (value is narrowed): " + value.byteValue());
    }
}
