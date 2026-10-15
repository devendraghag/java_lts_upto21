package com.example.methodreferences.instancemethodreference;

import java.util.List;
import java.util.function.Consumer;

/** Medium: forEach accepts Consumer<String>; the receiver is this particular printer. */
public class InstanceMethod09StreamForEach {
    private void printUppercase(String value) {
        System.out.println(value.toUpperCase());
    }

    public static void main(String[] args) {
        InstanceMethod09StreamForEach printer = new InstanceMethod09StreamForEach();
        List<String> words = List.of("lambda", "object", "reference");

        // Lambda equivalent: words.forEach(word -> printer.printUppercase(word))
        words.stream().forEach(printer::printUppercase);
    }
}
