package com.example.collectionclasses.arraylist;

import java.util.ArrayList;

/** Article approach 4: demonstrates double-brace initialization and its tradeoff. */
public class ArrayListInit04DoubleBraceDemo {
    public static void main(String[] args) {
        // The first braces create an anonymous ArrayList subclass.
        // The second braces are an instance initializer that adds values.
        ArrayList<String> names = new ArrayList<>() {{
            add("Asha");
            add("Ravi");
            add("Mina");
        }};

        System.out.println("Names: " + names);

        // This syntax creates an extra anonymous class. Prefer an ordinary
        // ArrayList plus add(), or new ArrayList<>(List.of(...)), in most code.
    }
}