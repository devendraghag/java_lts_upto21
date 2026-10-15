package com.example.continuestatement;

import java.util.List;

/** Uses continue to skip an element during enhanced-for traversal. */
public class ContinueEnhancedForDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "", "Ravi", "", "Mina");
        for (String name : names) {
            if (name.isBlank()) {
                continue;
            }
            System.out.println("Name: " + name);
        }
    }
}
