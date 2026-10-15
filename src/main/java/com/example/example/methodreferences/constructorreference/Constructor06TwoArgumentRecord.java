package com.example.methodreferences.constructorreference;

import java.util.function.BiFunction;

/** Medium: a two-parameter constructor matches BiFunction<T, U, R>. */
public class Constructor06TwoArgumentRecord {
    record Book(String title, int pages) {
    }

    public static void main(String[] args) {
        BiFunction<String, Integer, Book> lambda = (title, pages) -> new Book(title, pages);
        BiFunction<String, Integer, Book> reference = Book::new;

        System.out.println(lambda.apply("Java Basics", 240));
        System.out.println(reference.apply("Streams in Practice", 180));
    }
}
