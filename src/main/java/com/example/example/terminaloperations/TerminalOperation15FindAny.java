package com.example.example.terminaloperations;

import java.util.List;

/** findAny returns some matching value; parallel streams may choose any match. */
public class TerminalOperation15FindAny {
    public static void main(String[] args) {
        int anyEven = List.of(5, 8, 10, 12).parallelStream()
                .filter(number -> number % 2 == 0)
                .findAny()
                .orElseThrow();

        System.out.println("An even number: " + anyEven);
    }
}
