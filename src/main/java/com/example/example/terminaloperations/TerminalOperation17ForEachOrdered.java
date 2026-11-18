package com.example.example.terminaloperations;

import java.util.List;

/** forEachOrdered performs an action in encounter order, even on a parallel stream. */
public class TerminalOperation17ForEachOrdered {
    public static void main(String[] args) {
        List.of("first", "second", "third").parallelStream()
                .forEachOrdered(System.out::println);
    }
}
