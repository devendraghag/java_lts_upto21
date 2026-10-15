package com.example.methodreferences.constructorreference;

import java.util.function.Supplier;

/** Easy: StringBuilder::new refers to its no-argument constructor. */
public class Constructor02StringBuilder {
    public static void main(String[] args) {
        Supplier<StringBuilder> lambda = () -> new StringBuilder();
        Supplier<StringBuilder> reference = StringBuilder::new;

        System.out.println(lambda.get().append("Lambda"));
        System.out.println(reference.get().append("Constructor reference"));
    }
}
