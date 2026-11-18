package com.example.example.terminaloperations;

import java.util.List;

/** noneMatch is true when no element matches the condition. */
public class TerminalOperation13NoneMatch {
    public static void main(String[] args) {
        boolean hasNoZero = List.of(4, 2, 7).stream()
                .noneMatch(number -> number == 0);

        System.out.println("Contains no zero: " + hasNoZero);
    }
}
