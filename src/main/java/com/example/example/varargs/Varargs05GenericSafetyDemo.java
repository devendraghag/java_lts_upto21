package com.example.varargs;

import java.util.ArrayList;
import java.util.List;

/** Level 5: use generic varargs carefully and explain when @SafeVarargs is appropriate. */
public class Varargs05GenericSafetyDemo {
    public static void main(String[] args) {
        List<String> merged = combine(List.of("red", "green"), List.of("blue"));
        System.out.println(merged);
    }

    // Generic varargs use an array behind the scenes. This method is safe because
    // it only reads the input lists and copies their values into a new result list.
    @SafeVarargs
    private static <T> List<T> combine(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}
