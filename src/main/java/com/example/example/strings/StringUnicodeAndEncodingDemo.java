package com.example.strings;

import java.nio.charset.StandardCharsets;

/** Unicode code points and explicit byte encodings. */
public class StringUnicodeAndEncodingDemo {
    public static void main(String[] args) {
        String emojiText = "A😀B";
        System.out.println("UTF-16 length: " + emojiText.length());
        System.out.println("Unicode code point count: " + emojiText.codePointCount(0, emojiText.length()));
        emojiText.codePoints().forEach(codePoint ->
                System.out.println("Code point: U+" + Integer.toHexString(codePoint).toUpperCase()));

        String original = "Java café";
        byte[] bytes = original.getBytes(StandardCharsets.UTF_8);
        String decoded = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("UTF-8 round trip: " + decoded);
    }
}
