package com.example.tounmodifiablelist.list;

import java.util.List;
import java.util.stream.Collectors;

/** Shows how Collectors.toUnmodifiableList() collects stream elements. */
public class ToUnmodifiableList01BasicCollectorDemo {
    public static void main(String[] args) {
        List<String> topics = List.of("Java", "Streams", "Java");

        // The collector keeps the stream's encounter order and permits duplicates.
        List<String> collected = topics.stream()
                .filter(topic -> !topic.isBlank())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Source topics: " + topics);
        System.out.println("Collected list: " + collected);
    }
}
