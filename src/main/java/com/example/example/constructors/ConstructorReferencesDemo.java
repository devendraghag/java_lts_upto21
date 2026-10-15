package com.example.constructors;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/** Constructor references select an overload using the target functional-interface type. */
public class ConstructorReferencesDemo {
    public static void main(String[] args) {
        Supplier<Product> defaultProduct = Product::new;
        Function<String, Product> namedProduct = Product::new;
        BiFunction<String, Integer, Product> sizedProduct = Product::new;

        System.out.println(defaultProduct.get());
        System.out.println(namedProduct.apply("Notebook"));
        System.out.println(sizedProduct.apply("Monitor", 27));

        List<Product> products = List.of("pen", "book", "lamp").stream()
                .map(Product::new)
                .toList(); // Java 16+
        System.out.println(products);
    }

    private record Product(String name, int size) {
        Product() { this("unnamed", 0); }
        Product(String name) { this(name, 0); }
    }
}
