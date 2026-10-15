package com.example.staticimport;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/** Demonstrates single static imports of fields and methods. */
public class StaticImportSingleMemberDemo {
    public static void main(String[] args) {
        double radius = 3.0;
        double area = PI * radius * radius;

        out.println("Pi: " + PI);
        out.println("Square root of 81: " + sqrt(81));
        out.println("Circle area: " + area);
    }
}
