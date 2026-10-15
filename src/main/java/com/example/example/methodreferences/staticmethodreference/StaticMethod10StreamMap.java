package com.example.methodreferences.staticmethodreference;

import java.util.List;
import java.util.function.Function;

/** Medium: Stream.map accepts Function<String, Integer>; parseInt is static. */
public class StaticMethod10StreamMap {
    public static void main(String[] args) {
        List<String> rawValues = List.of("7", "21", "105");
        Function<String, Integer> lambda = text -> Integer.parseInt(text);
        Function<String, Integer> reference = Integer::parseInt;

        System.out.println(rawValues.stream().map(lambda).toList());
        System.out.println(rawValues.stream().map(reference).toList());
    }
}
