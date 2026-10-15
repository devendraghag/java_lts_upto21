package com.example.strings;

import java.nio.charset.StandardCharsets;

/** Common ways to create String values and an illustration of the string pool. */
public class StringCreationWaysDemo {
    public static void main(String[] args) {
        String literal = "Java";
        String explicitlyCreated = new String("Java");
        char[] letters = {'J', 'a', 'v', 'a'};
        String fromCharacters = new String(letters);
        byte[] utf8Bytes = "café".getBytes(StandardCharsets.UTF_8);
        String fromBytes = new String(utf8Bytes, StandardCharsets.UTF_8);
        String fromValueOf = String.valueOf(21);
        String fromCodePoint = new String(Character.toChars(0x1F600));

        System.out.println(literal);
        System.out.println(explicitlyCreated);
        System.out.println(fromCharacters);
        System.out.println(fromBytes);
        System.out.println(fromValueOf);
        System.out.println("Code point string: " + fromCodePoint);

        String sameLiteral = "Java";
        System.out.println("Equal contents: " + literal.equals(explicitlyCreated));
        System.out.println("Same literal reference: " + (literal == sameLiteral));
        System.out.println("Interned reference matches literal: "
                + (explicitlyCreated.intern() == literal));
    }
}
