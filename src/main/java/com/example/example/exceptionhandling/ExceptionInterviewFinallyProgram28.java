package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/*
 * Interview level: Beginner.
 * Feature combination/topic: finally behavior.
 *
 * Notes:
 * - Kept in the JDK1_0 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Exception Interview Finally Program28 in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class ExceptionInterviewFinallyProgram28 {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("try");
        } finally {
            System.out.println("finally always runs unless JVM exits");
        }
    }
}