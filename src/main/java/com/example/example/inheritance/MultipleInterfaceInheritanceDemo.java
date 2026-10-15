package com.example.inheritance;

/** Demonstrates a class implementing multiple interfaces and resolving defaults. */
public class MultipleInterfaceInheritanceDemo {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print("Report");
        printer.scan("Page 1");
        printer.describe();
    }

    private interface Printable {
        void print(String text);

        default void describe() {
            System.out.println("Can print documents.");
        }
    }

    private interface Scannable {
        void scan(String text);

        default void describe() {
            System.out.println("Can scan documents.");
        }
    }

    private static final class MultiFunctionPrinter implements Printable, Scannable {
        @Override
        public void print(String text) {
            System.out.println("Printing: " + text);
        }

        @Override
        public void scan(String text) {
            System.out.println("Scanning: " + text);
        }

        @Override
        public void describe() {
            Printable.super.describe();
            Scannable.super.describe();
        }
    }
}
