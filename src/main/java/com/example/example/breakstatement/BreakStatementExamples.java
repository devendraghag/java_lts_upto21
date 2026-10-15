package com.example.breakstatement;

/**
 * Demonstrates Java's unlabeled and labeled break statements, including their
 * use in loops, blocks, and switch statements through JDK 21.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/breakstatement/BreakStatementExamples.java
 *   java -cp out com.example.breakstatement.BreakStatementExamples
 */
public class BreakStatementExamples {
    public static void main(String[] args) {
        breakFromForLoop();
        breakFromWhileLoop();
        breakFromEnhancedForLoop();
        unlabeledBreakInNestedLoop();
        labeledBreakFromNestedLoops();
        labeledBreakFromBlock();
        breakInSwitchStatements();
    }

    private static void breakFromForLoop() {
        System.out.println("== Unlabeled break in a for loop ==");

        for (int number = 1; number <= 8; number++) {
            if (number == 5) {
                System.out.println("Found 5; break exits the nearest loop");
                break;
            }
            System.out.print(number + " ");
        }
        System.out.println("\nLoop ended early");
    }

    private static void breakFromWhileLoop() {
        System.out.println("\n== Unlabeled break in a while loop ==");

        int remaining = 3;
        while (true) { // intentional loop; break is its exit condition
            System.out.println("remaining: " + remaining);
            remaining--;
            if (remaining == 0) {
                break;
            }
        }
        System.out.println("while loop ended");
    }

    private static void breakFromEnhancedForLoop() {
        System.out.println("\n== Unlabeled break in an enhanced for loop ==");

        String[] names = {"Asha", "Ravi", "Mina", "Zoe"};
        for (String name : names) {
            if (name.equals("Mina")) {
                System.out.println("Stopping at " + name);
                break;
            }
            System.out.println(name);
        }
    }

    private static void unlabeledBreakInNestedLoop() {
        System.out.println("\n== Unlabeled break exits only the innermost loop ==");

        for (int row = 1; row <= 2; row++) {
            for (int column = 1; column <= 4; column++) {
                if (column == 3) {
                    break; // only the column loop ends
                }
                System.out.println("row=" + row + ", column=" + column);
            }
        }
    }

    private static void labeledBreakFromNestedLoops() {
        System.out.println("\n== Labeled break exits the named outer loop ==");

        search:
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 4; column++) {
                if (row == 2 && column == 3) {
                    System.out.println("Target found at row=" + row + ", column=" + column);
                    break search; // leaves both loops and continues after the labeled loop
                }
            }
        }
        System.out.println("Search finished");
    }

    private static void labeledBreakFromBlock() {
        System.out.println("\n== Labeled break exits a labeled block ==");

        calculation: {
            int value = 10;
            if (value > 0) {
                System.out.println("Positive value; leave this block early");
                break calculation;
            }
            System.out.println("This line is skipped");
        }
        System.out.println("Execution continues after the labeled block");
    }

    private static void breakInSwitchStatements() {
        System.out.println("\n== break in switch statements ==");

        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break; // prevents fall-through to case 2
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other day");
                break;
        }

        // Arrow-style switch labels do not fall through, so a break is unnecessary.
        String description = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "Other day";
        };
        System.out.println("Arrow switch result: " + description);
    }
}
