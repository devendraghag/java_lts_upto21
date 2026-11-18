package com.example.example.wrapperclasses;

/** Parsing invalid numeric text throws NumberFormatException. */
public class WrapperClass04InvalidTextTrap {
    public static void main(String[] args) {
        String input = "12x";

        try {
            int value = Integer.parseInt(input);
            System.out.println(value);
        } catch (NumberFormatException exception) {
            System.out.println("Cannot parse '" + input + "' as an int");
        }
    }
}
