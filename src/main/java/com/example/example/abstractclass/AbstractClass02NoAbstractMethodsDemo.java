package com.example.abstractclass;

/** Shows an abstract class may contain no abstract methods. */
public class AbstractClass02NoAbstractMethodsDemo {
    public static void main(String[] args) {
        Document document = new PdfDocument("Guide.pdf");
        document.printTitle();
        document.open();
    }

    // Abstract prevents direct construction and leaves room for specialized document types.
    private abstract static class Document {
        private final String title;

        protected Document(String title) {
            this.title = title;
        }

        public void printTitle() {
            System.out.println("Title: " + title);
        }

        public void open() {
            System.out.println("Opening document");
        }
    }

    private static final class PdfDocument extends Document {
        private PdfDocument(String title) {
            super(title);
        }
    }
}
