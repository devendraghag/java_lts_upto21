package com.example.stringbuffer;

/**
 * Demonstrates StringBuffer constructors, methods, capacity, and thread-safety
 * through JDK 21. No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/stringbuffer/StringBufferExamples.java
 *   java -cp out com.example.stringbuffer.StringBufferExamples
 */
public class StringBufferExamples {
    public static void main(String[] args) throws InterruptedException {
        constructorsAndCapacity();
        appendAndInsert();
        searchAndModify();
        lengthAndConversion();
        synchronizedAppendExample();
        compareStringTypes();
    }

    private static void constructorsAndCapacity() {
        System.out.println("== Constructors and capacity ==");

        StringBuffer empty = new StringBuffer();
        StringBuffer sized = new StringBuffer(40);
        StringBuffer fromText = new StringBuffer("Java");
        StringBuffer fromCharacters = new StringBuffer((CharSequence) "Buffer");

        System.out.println("default capacity: " + empty.capacity());
        System.out.println("requested capacity: " + sized.capacity());
        System.out.println("initial text and capacity: " + fromText + " / " + fromText.capacity());
        System.out.println("CharSequence constructor: " + fromCharacters);

        fromText.ensureCapacity(100);
        System.out.println("capacity after ensureCapacity(100): " + fromText.capacity());
        fromText.trimToSize();
        System.out.println("capacity after trimToSize(): " + fromText.capacity());
    }

    private static void appendAndInsert() {
        System.out.println("\n== Append, insert, and chaining ==");

        StringBuffer text = new StringBuffer("Java");
        text.append(' ').append("JDK ").append(21).append(" ").append(true);
        System.out.println("append overloads: " + text);

        text.insert(5, "StringBuffer ");
        System.out.println("insert(index, value): " + text);
        text.appendCodePoint(0x1F642); // append a Unicode code point
        System.out.println("appendCodePoint: " + text);
    }

    private static void searchAndModify() {
        System.out.println("\n== Search and modify ==");

        StringBuffer text = new StringBuffer("Java is fast");
        System.out.println("charAt / indexOf / lastIndexOf: "
                + text.charAt(0) + " / " + text.indexOf("is") + " / " + text.lastIndexOf("a"));

        text.setCharAt(0, 'j');
        System.out.println("setCharAt: " + text);
        text.replace(0, 4, "Java"); // end index is exclusive
        System.out.println("replace(start, end, text): " + text);
        text.delete(4, 7); // delete indexes 4 through 6
        System.out.println("delete(start, end): " + text);
        text.deleteCharAt(text.length() - 1);
        System.out.println("deleteCharAt: " + text);

        StringBuffer reversed = new StringBuffer("desserts").reverse();
        System.out.println("reverse: " + reversed);
    }

    private static void lengthAndConversion() {
        System.out.println("\n== Length, subsequences, and conversion ==");

        StringBuffer text = new StringBuffer("Java Buffer");
        System.out.println("length: " + text.length());
        System.out.println("substring: " + text.substring(5));
        System.out.println("subSequence: " + text.subSequence(0, 4));
        System.out.println("toString: " + text.toString());

        text.setLength(4); // truncate
        System.out.println("setLength shorter: " + text);
        text.setLength(6); // extending fills new positions with NUL characters
        System.out.println("setLength longer; length=" + text.length()
                + ", new character code=" + (int) text.charAt(5));
    }

    private static void synchronizedAppendExample() throws InterruptedException {
        System.out.println("\n== Synchronized append from two threads ==");

        StringBuffer shared = new StringBuffer();
        Runnable appendA = () -> appendRepeatedly(shared, 'A', 1_000);
        Runnable appendB = () -> appendRepeatedly(shared, 'B', 1_000);
        Thread first = new Thread(appendA, "append-A");
        Thread second = new Thread(appendB, "append-B");
        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println("length after both threads: " + shared.length());
        System.out.println("A count / B count: " + count(shared, 'A') + " / " + count(shared, 'B'));
        // The order of A and B characters can vary. Individual StringBuffer methods
        // are synchronized; a sequence of multiple calls is not automatically atomic.
    }

    private static void appendRepeatedly(StringBuffer target, char value, int count) {
        for (int i = 0; i < count; i++) {
            target.append(value);
        }
    }

    private static long count(StringBuffer text, char value) {
        long result = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == value) {
                result++;
            }
        }
        return result;
    }

    private static void compareStringTypes() {
        System.out.println("\n== String, StringBuilder, and StringBuffer ==");

        String immutable = "Java";
        String changed = immutable.concat(" 21");
        StringBuilder builder = new StringBuilder("Java");
        StringBuffer buffer = new StringBuffer("Java");
        builder.append(" 21");
        buffer.append(" 21");

        System.out.println("String remains unchanged: " + immutable + " -> " + changed);
        System.out.println("StringBuilder (not synchronized): " + builder);
        System.out.println("StringBuffer (synchronized methods): " + buffer);
        // Prefer StringBuilder for local single-threaded construction; use StringBuffer
        // when its per-method synchronization is useful. Synchronization does not make
        // a multi-call workflow atomic.
    }
}
