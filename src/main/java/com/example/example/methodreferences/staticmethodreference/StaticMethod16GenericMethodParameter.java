package com.example.methodreferences.staticmethodreference;

import java.util.List;
import java.util.function.Function;

/** Hard: pass a static method reference into a generic method expecting Function<T, R>. */
public class StaticMethod16GenericMethodParameter {
    static <T, R> List<R> convertAll(List<T> values, Function<T, R> converter) {
        return values.stream().map(converter).toList();
    }

    public static void main(String[] args) {
        List<String> values = List.of("12", "34", "56");

        // Lambda equivalent: convertAll(values, text -> Integer.parseInt(text))
        List<Integer> parsed = convertAll(values, Integer::parseInt);
        System.out.println(parsed);
    }
}
