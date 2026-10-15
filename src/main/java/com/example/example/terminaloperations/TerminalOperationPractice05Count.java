package com.example.terminaloperations;

import java.util.List;

/** Easy+: count returns long and executes the preceding filter pipeline. */
public class TerminalOperationPractice05Count {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "API", "Streams", "JDK");

        long total = words.stream().count();
        long longerWords = words.stream().filter(word -> word.length() > 3).count();

        System.out.println("Total words: " + total);
        System.out.println("Words longer than 3 characters: " + longerWords);
    }
}
