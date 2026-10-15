package com.example.abstractclass;

/** Template method fixes the algorithm order and lets subclasses fill in steps. */
public class AbstractClass09TemplateMethodDemo {
    public static void main(String[] args) {
        DataImporter importer = new CsvImporter();
        importer.importData();
    }

    private abstract static class DataImporter {
        public final void importData() {
            open();
            parse();
            close();
        }

        private void open() { System.out.println("Open source"); }
        protected abstract void parse();
        private void close() { System.out.println("Close source"); }
    }

    private static final class CsvImporter extends DataImporter {
        @Override
        protected void parse() { System.out.println("Parse CSV rows"); }
    }
}
