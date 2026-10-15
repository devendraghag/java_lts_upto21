package com.example.stringtokenizer;

import java.util.StringTokenizer;

/** Default whitespace delimiters, token iteration, and countTokens(). */
public class StringTokenizerDefaultAndCountDemo {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("Java   has\tuseful\ntext tools");
        System.out.println("Tokens available: " + tokenizer.countTokens());

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        System.out.println("Tokens left: " + tokenizer.countTokens());
    }
}
