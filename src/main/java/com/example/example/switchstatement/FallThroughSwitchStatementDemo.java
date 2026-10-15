package com.example.switchstatement;

/** Demonstrates intentional fall-through and explicit break in classic switch statements. */
public class FallThroughSwitchStatementDemo {
    private static void printQuarter(int month) {
        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("First quarter");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Second quarter");
                break;
            default:
                System.out.println("This example handles months 1 through 6");
                break;
        }
    }

    public static void main(String[] args) {
        printQuarter(2);
        printQuarter(5);
        printQuarter(9);
    }
}
