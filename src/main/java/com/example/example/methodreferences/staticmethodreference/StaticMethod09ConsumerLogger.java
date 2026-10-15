package com.example.methodreferences.staticmethodreference;

import java.util.function.Consumer;

/** Medium: a static void method taking one String matches Consumer<String>. */
public class StaticMethod09ConsumerLogger {
    static class Logger {
        static void info(String message) {
            System.out.println("INFO: " + message);
        }
    }

    public static void main(String[] args) {
        Consumer<String> lambda = message -> Logger.info(message);
        Consumer<String> reference = Logger::info;

        lambda.accept("starting");
        reference.accept("finished");
    }
}
