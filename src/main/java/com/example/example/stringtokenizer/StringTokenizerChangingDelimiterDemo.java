package com.example.stringtokenizer;

import java.util.StringTokenizer;

/** Changes the active delimiter set for the remaining input with nextToken(delim). */
public class StringTokenizerChangingDelimiterDemo {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("alpha,beta|gamma", ",");
        System.out.println(tokenizer.nextToken());       // alpha
        System.out.println(tokenizer.nextToken("|"));   // beta; delimiter set changes to |
        System.out.println(tokenizer.nextToken());       // gamma, still using |
    }
}
