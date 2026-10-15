package com.example.comparable;

import java.util.List;

public class Comparable10BookComparable {
    record Book(String title, int edition, int price) implements Comparable<Book> {
        @Override
        public int compareTo(Book other) {
            int byTitle = title.compareTo(other.title);
            return byTitle != 0 ? byTitle : Integer.compare(edition, other.edition);
        }
    }

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Java", 2, 50),
                new Book("Algorithms", 1, 80),
                new Book("Java", 1, 40));
        System.out.println(books.stream().sorted().toList());
    }
}
