package com.example.designpattern.behavioral;

// Each exporter follows the same steps but supplies its own report body.
public class TemplateMethod02ReportDemo {
    abstract static class ReportExporter {
        public final void export() {
            open(); writeHeader(); writeBody(); close();
        }
        private void open() { System.out.println("Open output"); }
        private void writeHeader() { System.out.println("Write report header"); }
        protected abstract void writeBody();
        private void close() { System.out.println("Close output"); }
    }
    static class CsvExporter extends ReportExporter {
        protected void writeBody() { System.out.println("Write comma-separated rows"); }
    }
    static class TextExporter extends ReportExporter {
        protected void writeBody() { System.out.println("Write plain-text rows"); }
    }
    public static void main(String[] args) {
        new CsvExporter().export();
        new TextExporter().export();
    }
}
