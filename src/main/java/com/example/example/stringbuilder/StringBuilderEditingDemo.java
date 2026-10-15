package com.example.stringbuilder;

/** Demonstrates common in-place StringBuilder editing operations. */
public class StringBuilderEditingDemo {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Java is fun");
        text.insert(8, "really ");
        System.out.println("insert: " + text);

        text.replace(8, 15, "powerful");
        System.out.println("replace: " + text);

        text.delete(8, 16);
        System.out.println("delete range: " + text);

        text.append("!");
        text.setCharAt(0, 'j');
        System.out.println("append and setCharAt: " + text);

        text.reverse();
        System.out.println("reverse: " + text);
        text.reverse();
        text.setLength(4);
        System.out.println("setLength to shorten: " + text);
    }
}
