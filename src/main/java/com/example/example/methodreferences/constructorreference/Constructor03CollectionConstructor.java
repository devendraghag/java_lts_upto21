package com.example.methodreferences.constructorreference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/** Easy+: ArrayList::new refers to the constructor that copies a Collection. */
public class Constructor03CollectionConstructor {
    public static void main(String[] args) {
        Function<Collection<String>, ArrayList<String>> lambda = values -> new ArrayList<>(values);
        Function<Collection<String>, ArrayList<String>> reference = ArrayList::new;
        Collection<String> source = List.of("Java", "Streams");

        System.out.println(lambda.apply(source));
        System.out.println(reference.apply(source));
    }
}
