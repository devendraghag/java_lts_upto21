package com.example.abstractclass;

/** Demonstrates an abstract class implementing only part of an interface. */
public class AbstractClass08ImplementsInterfaceDemo {
    public static void main(String[] args) {
        Report report = new SalesReport("Q3 Sales");
        report.print();
        report.export();
    }

    private interface Exportable {
        void export();
        void print();
    }

    private abstract static class Report implements Exportable {
        private final String title;

        protected Report(String title) {
            this.title = title;
        }

        @Override
        public void print() {
            System.out.println("Report: " + title);
        }
        // The class remains abstract until a subclass implements export().
    }

    private static final class SalesReport extends Report {
        private SalesReport(String title) {
            super(title);
        }

        @Override
        public void export() {
            System.out.println("Exported report as CSV");
        }
    }
}
