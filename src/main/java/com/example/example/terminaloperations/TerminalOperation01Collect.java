package com.example.example.terminaloperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** collect gathers stream elements into a result container. */
public class TerminalOperation01Collect {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Aman", "Ravi", "Rita");

        Map<Character, List<String>> namesByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("Names grouped by first letter: " + namesByFirstLetter);
    }
}
