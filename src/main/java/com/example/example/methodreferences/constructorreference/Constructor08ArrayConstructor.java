package com.example.methodreferences.constructorreference;

import java.util.Arrays;
import java.util.function.IntFunction;

/** Medium: array constructor references use Type[]::new and an integer size. */
public class Constructor08ArrayConstructor {
    public static void main(String[] args) {
        IntFunction<String[]> lambda = size -> new String[size];
        IntFunction<String[]> reference = String[]::new;

        System.out.println(Arrays.toString(lambda.apply(3)));
        System.out.println(Arrays.toString(reference.apply(5)));
    }
}
