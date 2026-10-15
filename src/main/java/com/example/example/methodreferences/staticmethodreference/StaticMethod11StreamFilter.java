package com.example.methodreferences.staticmethodreference;

import java.util.List;
import java.util.function.Predicate;

/** Medium: Stream.filter accepts a Predicate; this static method tests each Integer. */
public class StaticMethod11StreamFilter {
    static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> lambda = number -> StaticMethod11StreamFilter.isEven(number);
        Predicate<Integer> reference = StaticMethod11StreamFilter::isEven;

        System.out.println(values.stream().filter(lambda).toList());
        System.out.println(values.stream().filter(reference).toList());
    }
}
