package com.example.stringtokenizer;

import java.util.Enumeration;
import java.util.StringTokenizer;

/** Returns separators as tokens and uses the Enumeration API. */
public class StringTokenizerReturnDelimitersDemo {
    public static void main(String[] args) {
        StringTokenizer withDelimiters = new StringTokenizer("A+B-C", "+-", true);
        while (withDelimiters.hasMoreTokens()) {
            System.out.println("Token: [" + withDelimiters.nextToken() + "]");
        }

        Enumeration<Object> enumeration = new StringTokenizer("one,two,three", ",");
        while (enumeration.hasMoreElements()) {
            Object next = enumeration.nextElement();
            System.out.println("Enumeration element: " + next);
        }

        // Enumeration.asIterator() is available since Java 9.
        StringTokenizer asIteratorSource = new StringTokenizer("jdk,21", ",");
        asIteratorSource.asIterator().forEachRemaining(System.out::println);
    }
}
