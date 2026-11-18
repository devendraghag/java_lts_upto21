package com.example.example.wrapperclasses;

/** Float and Double can represent NaN and infinity in addition to ordinary values. */
public class WrapperClass10FloatingPointSpecialValues {
    public static void main(String[] args) {
        double notANumber = Double.NaN;
        double infinity = Double.POSITIVE_INFINITY;

        System.out.println("Is NaN: " + Double.isNaN(notANumber));
        System.out.println("NaN == NaN: " + (notANumber == notANumber));
        System.out.println("Use Double.compare for NaN values: "
                + (Double.compare(notANumber, Double.NaN) == 0));
        System.out.println("Is infinite: " + Double.isInfinite(infinity));
        System.out.println("Is finite: " + Double.isFinite(12.5));
    }
}
