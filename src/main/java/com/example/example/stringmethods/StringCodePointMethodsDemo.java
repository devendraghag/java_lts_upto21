package com.example.stringmethods;

/** Demonstrates that String indices use UTF-16 code units, not Unicode code points. */
public class StringCodePointMethodsDemo {
    public static void main(String[] args) {
        String text = "A😀B";
        System.out.println("UTF-16 length: " + text.length());
        System.out.println("Unicode code point count: " + text.codePointCount(0, text.length()));

        for (int offset = 0; offset < text.length();) {
            int codePoint = text.codePointAt(offset);
            System.out.printf("U+%X%n", codePoint);
            offset += Character.charCount(codePoint);
        }
    }
}
