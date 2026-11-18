package com.example.example.terminaloperations;

import java.util.List;

/** allMatch is true when every element matches the condition. */
public class TerminalOperation12AllMatch {
    public static void main(String[] args) {
        boolean allPositive = List.of(4, 2, 7).stream()
                .allMatch(number -> number > 0);

        System.out.println("All numbers are positive: " + allPositive);
    }
}
