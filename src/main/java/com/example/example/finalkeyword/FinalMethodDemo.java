package com.example.finalkeyword;

/** A final instance method is inherited but cannot be overridden. */
public class FinalMethodDemo {
    public static void main(String[] args) {
        Report report = new DetailedReport();
        report.print();
        report.validate();
    }

    private static class Report {
        final void validate() {
            System.out.println("Shared validation cannot be overridden");
        }

        void print() {
            System.out.println("Base report");
        }
    }

    private static class DetailedReport extends Report {
        @Override
        void print() {
            System.out.println("Detailed report");
        }

        // @Override void validate() {} // Compile-time error: validate() is final.
    }
}
