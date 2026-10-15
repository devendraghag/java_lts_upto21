package com.example.switchstatement;

/** Demonstrates the traditional colon-label switch statement. */
public class ClassicSwitchStatementDemo {
    public static void main(String[] args) {
        int month = 2;
        int days;

        switch (month) {
            case 1:
                days = 31;
                break;
            case 2:
                days = 28; // This simple example does not account for leap years.
                break;
            case 3:
                days = 31;
                break;
            default:
                days = 0;
                break;
        }

        if (days == 0) {
            System.out.println("Month is outside this example's range");
        } else {
            System.out.println("Month " + month + " has " + days + " days");
        }
    }
}
