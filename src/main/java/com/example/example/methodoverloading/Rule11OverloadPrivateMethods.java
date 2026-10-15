package com.example.example.methodoverloading;

/** Rule 11: private methods can be overloaded within their class. */
public class Rule11OverloadPrivateMethods {
    private String label(int value) {
        return "number " + value;
    }

    private String label(String value) {
        return "text " + value;
    }

    public static void main(String[] args) {
        Rule11OverloadPrivateMethods example = new Rule11OverloadPrivateMethods();
        System.out.println(example.label(8));
        System.out.println(example.label("eight"));
    }
}
