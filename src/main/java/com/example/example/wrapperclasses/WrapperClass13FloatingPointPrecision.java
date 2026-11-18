package com.example.example.wrapperclasses;

import java.math.BigDecimal;

/** Double uses binary floating point; BigDecimal.valueOf is useful for decimal money values. */
public class WrapperClass13FloatingPointPrecision {
    public static void main(String[] args) {
        double total = 0.1 + 0.2;
        BigDecimal decimalTotal = BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2));

        System.out.println("Double result: " + total);
        System.out.println("BigDecimal result: " + decimalTotal);
    }
}
