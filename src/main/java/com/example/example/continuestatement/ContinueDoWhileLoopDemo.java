package com.example.continuestatement;

/** Uses continue in a do-while loop; the condition is still checked afterward. */
public class ContinueDoWhileLoopDemo {
    public static void main(String[] args) {
        int number = 0;
        do {
            number++;
            if (number == 3) {
                continue;
            }
            System.out.println("Visited: " + number);
        } while (number < 5);
    }
}
