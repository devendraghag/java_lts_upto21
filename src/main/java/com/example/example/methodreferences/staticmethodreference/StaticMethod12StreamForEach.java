package com.example.methodreferences.staticmethodreference;

import java.util.List;
import java.util.function.Consumer;

/** Medium: forEach accepts Consumer<Integer>; a static void method prints each number. */
public class StaticMethod12StreamForEach {
    static void showNumber(Integer number) {
        System.out.println("Number = " + number);
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(10, 20, 30);
        Consumer<Integer> lambda = number -> StaticMethod12StreamForEach.showNumber(number);
        Consumer<Integer> reference = StaticMethod12StreamForEach::showNumber;

        values.forEach(lambda);
        System.out.println("Method reference:");
        values.forEach(reference);
    }
}
