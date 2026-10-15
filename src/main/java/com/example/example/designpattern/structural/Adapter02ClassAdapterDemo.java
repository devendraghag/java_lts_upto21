package com.example.designpattern.structural;

// Class Adapter: inheritance adapts a legacy class to the interface the client needs.
public class Adapter02ClassAdapterDemo {
    static class LegacyPrinter {
        void printText(String text) { System.out.println("Legacy printer: " + text); }
    }
    interface Printer { void print(String text); }

    // Java has single class inheritance, so this style is less flexible than object adaptation.
    static class PrinterAdapter extends LegacyPrinter implements Printer {
        public void print(String text) { printText(text); }
    }

    public static void main(String[] args) {
        Printer printer = new PrinterAdapter();
        printer.print("Hello from the expected interface");
    }
}
