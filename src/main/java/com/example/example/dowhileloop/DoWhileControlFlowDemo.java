package com.example.dowhileloop;

/** Uses continue and break inside a do-while loop. */
public class DoWhileControlFlowDemo {
    public static void main(String[] args) {
        int value = 0;
        int oddTotal = 0;

        do {
            value++;
            if (value % 2 == 0) {
                continue; // Jumps to the do-while condition check.
            }
            if (value == 9) {
                break; // Exits the loop before adding 9.
            }
            oddTotal += value;
            System.out.println("Added odd value: " + value);
        } while (value < 10);

        System.out.println("Odd total before 9: " + oddTotal);
    }
}
