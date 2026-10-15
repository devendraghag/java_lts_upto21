package com.example.methodreferences.instancemethodreference;

import java.util.function.Consumer;

/** Easy: the captured printer receives each Consumer input. */
public class InstanceMethod02Consumer {
    static class Printer {
        void print(String message) {
            System.out.println("Printed: " + message);
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Consumer<String> lambda = message -> printer.print(message);
        Consumer<String> reference = printer::print;

        lambda.accept("lambda");
        reference.accept("method reference");
    }
}
