package com.example.variables;

/** Level 09: Explicit narrowing conversions and truncation toward zero. */
public class Variable09NarrowingCastingDemo {
    public static void main(String[] args) {
        float f = 10.5f;
        // int a = f; // Compile-time error: float cannot be assigned to int implicitly.
        int a = (int) f;
        System.out.println(f); // 10.5
        System.out.println(a); // 10: the fractional part is discarded.

        float negative = -10.5f;
        System.out.println((int) negative); // -10; narrowing truncates toward zero.
    }
}
