package com.example.example.helloworldways;

/** Java 15: combines a text block with the formatted() String method. */
public class HelloWorld15FormattedTextBlock {
    public static void main(String[] args) {
        String message = """
                Hello, %s!
                """.formatted("World");
        System.out.print(message);
    }
}
