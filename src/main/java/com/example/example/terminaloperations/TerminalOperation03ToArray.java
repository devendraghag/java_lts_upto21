package com.example.example.terminaloperations;

import java.util.List;

/** toArray creates an array from the stream values. */
public class TerminalOperation03ToArray {
    public static void main(String[] args) {
        List<String> names = List.of("Mina", "Omar", "Pia");

        Object[] objects = names.stream().toArray();
        String[] strings = names.stream().toArray(String[]::new);

        System.out.println("Object array: " + java.util.Arrays.toString(objects));
        System.out.println("String array: " + java.util.Arrays.toString(strings));
    }
}
