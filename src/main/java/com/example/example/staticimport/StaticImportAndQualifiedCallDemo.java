package com.example.staticimport;

import static java.lang.Math.max;

/** Shows a static import alongside a class-qualified call for clarity. */
public class StaticImportAndQualifiedCallDemo {
    public static void main(String[] args) {
        int firstMaximum = max(12, 19);
        double secondMaximum = java.lang.Math.max(4.5, 7.25);

        System.out.println("Imported max(int, int): " + firstMaximum);
        System.out.println("Qualified max(double, double): " + secondMaximum);
        System.out.println("A qualified constant: " + java.lang.Math.PI);
    }
}
