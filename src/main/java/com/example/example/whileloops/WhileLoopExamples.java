package com.example.whileloops;

/**
 * Demonstrates while-loop forms and common control-flow techniques in Java.
 * Uses standard Java features available through JDK 21; no preview or
 * incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/whileloops/WhileLoopExamples.java
 *   java -cp out com.example.whileloops.WhileLoopExamples
 */
public class WhileLoopExamples {
    public static void main(String[] args) {
        basicWhile();
        accumulateWhile();
        doWhile();
        sentinelStyleLoop();
        nestedWhile();
        breakAndContinue();
        labeledBreak();
    }

    private static void basicWhile() {
        System.out.println("== Basic while loop ==");

        int count = 1;
        while (count <= 5) { // condition is checked before each iteration
            System.out.print(count + " ");
            count++;         // update the condition so the loop eventually ends
        }
        System.out.println();
    }

    private static void accumulateWhile() {
        System.out.println("\n== Use while to calculate a total ==");

        int number = 1;
        int total = 0;
        while (number <= 10) {
            total += number;
            number++;
        }
        System.out.println("Sum from 1 through 10: " + total);
    }

    private static void doWhile() {
        System.out.println("\n== do-while loop ==");

        int attempts = 0;
        do {
            attempts++;
            System.out.println("This body runs before the condition; attempt " + attempts);
        } while (attempts < 1); // trailing semicolon is required

        System.out.println("do-while executes at least once");
    }

    private static void sentinelStyleLoop() {
        System.out.println("\n== Sentinel-style loop ==");

        // A sentinel is a value or state that ends repetition. Here, 0 is the sentinel.
        int[] values = {4, 7, 2, 0, 9};
        int index = 0;
        int total = 0;
        while (index < values.length && values[index] != 0) {
            total += values[index];
            index++;
        }
        System.out.println("Stopped at sentinel 0; total before it: " + total);

        // In an input program, the same structure can read values until the sentinel arrives.
    }

    private static void nestedWhile() {
        System.out.println("\n== Nested while loops ==");

        int row = 1;
        while (row <= 3) {
            int column = 1;
            while (column <= 4) {
                System.out.print(row * column + "\t");
                column++;
            }
            System.out.println();
            row++;
        }
    }

    private static void breakAndContinue() {
        System.out.println("\n== break and continue ==");

        int value = 0;
        while (value < 10) {
            value++;
            if (value == 3) {
                continue; // skip the rest of this iteration
            }
            if (value == 7) {
                break;    // leave the loop immediately
            }
            System.out.print(value + " ");
        }
        System.out.println("(stopped at 7)");
    }

    private static void labeledBreak() {
        System.out.println("\n== Labeled break from nested loops ==");

        int row = 1;
        search:
        while (row <= 3) {
            int column = 1;
            while (column <= 4) {
                if (row == 2 && column == 3) {
                    System.out.println("Found target at row " + row + ", column " + column);
                    break search; // exits both loops at the labeled statement
                }
                column++;
            }
            row++;
        }
    }
}
