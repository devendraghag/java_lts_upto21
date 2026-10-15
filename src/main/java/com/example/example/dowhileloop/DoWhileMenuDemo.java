package com.example.dowhileloop;

import java.util.Scanner;

/** Simple menu loop that repeats until the user chooses Exit. */
public class DoWhileMenuDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n1. Say hello\n2. Show Java version\n0. Exit");
            System.out.print("Choose: ");

            if (!scanner.hasNext()) {
                System.out.println("No more input; exiting.");
                break;
            }
            if (!scanner.hasNextInt()) {
                System.out.println("Enter a menu number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Hello, World!");
                case 2 -> System.out.println("Java feature version: "
                        + Runtime.version().feature());
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Choose 1, 2, or 0.");
            }
        } while (choice != 0);
    }
}
