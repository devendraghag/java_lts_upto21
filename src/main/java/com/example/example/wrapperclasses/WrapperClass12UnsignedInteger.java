package com.example.example.wrapperclasses;

/** Integer provides unsigned helpers even though the int bit pattern is unchanged. */
public class WrapperClass12UnsignedInteger {
    public static void main(String[] args) {
        int bits = -1;

        System.out.println("Signed display: " + bits);
        System.out.println("Unsigned display: " + Integer.toUnsignedString(bits));
        System.out.println("Unsigned compare -1 and 1: " + Integer.compareUnsigned(-1, 1));
        System.out.println("Unsigned parse of 4294967295: "
                + Integer.toUnsignedString(Integer.parseUnsignedInt("4294967295")));
    }
}
