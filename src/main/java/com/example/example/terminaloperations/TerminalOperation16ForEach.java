package com.example.example.terminaloperations;

import java.util.List;

/** forEach performs an action for every element; parallel order is not guaranteed. */
public class TerminalOperation16ForEach {
    public static void main(String[] args) {
        List.of("red", "green", "blue").parallelStream()
                .forEach(color -> System.out.println(
                        Thread.currentThread().getName() + " -> " + color));
    }
}
