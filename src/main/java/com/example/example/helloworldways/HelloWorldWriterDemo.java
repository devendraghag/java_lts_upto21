package com.example.helloworldways;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/** Writes the greeting through PrintWriter and BufferedWriter. */
public class HelloWorldWriterDemo {
    public static void main(String[] args) throws Exception {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello, World! — PrintWriter");

        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        bufferedWriter.write("Hello, World! — BufferedWriter");
        bufferedWriter.newLine();
        bufferedWriter.flush(); // Flush, but do not close System.out.
    }
}
