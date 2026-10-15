package com.example.methodreferences.constructorreference;

import java.util.List;
import java.util.function.Function;

/** Challenge: compose a constructor reference as a Function and reuse it in a Stream. */
public class Constructor16ConstructorReferencePipeline {
    record Product(String name) {
    }

    public static void main(String[] args) {
        Function<String, Product> lambda = name -> new Product(name);
        Function<String, Product> constructor = Product::new;
        List<String> names = List.of("Keyboard", "Monitor", "Mouse");

        System.out.println("Lambda conversion: " + lambda.apply("Webcam"));
        System.out.println("Mapped products: " + names.stream().map(constructor).toList());
    }
}
