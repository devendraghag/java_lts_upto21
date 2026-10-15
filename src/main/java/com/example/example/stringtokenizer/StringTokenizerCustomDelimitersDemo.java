package com.example.stringtokenizer;

import java.util.StringTokenizer;

/** Custom delimiter characters; delimiters are treated as a set, not as a regex. */
public class StringTokenizerCustomDelimitersDemo {
    public static void main(String[] args) {
        String data = "red,green;blue|yellow";
        StringTokenizer tokenizer = new StringTokenizer(data, ",;|");

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
