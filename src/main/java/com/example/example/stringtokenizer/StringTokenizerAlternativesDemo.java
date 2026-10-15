package com.example.stringtokenizer;

import java.util.Arrays;

/** Compares StringTokenizer with String split APIs, including the Java 21 delimiter-aware split. */
public class StringTokenizerAlternativesDemo {
    public static void main(String[] args) {
        String input = "red,green;blue";

        // split takes a regular expression; a character class matches comma or semicolon.
        System.out.println("split: " + Arrays.toString(input.split("[,;]")));

        // Java 21: splitWithDelimiters includes each separator in the returned array.
        System.out.println("split with delimiters: "
                + Arrays.toString(input.splitWithDelimiters("[,;]", -1)));

        // StringTokenizer treats each character in its delimiter argument as a delimiter.
        // Prefer split or java.util.regex for new code when regex behavior is useful.
    }
}
