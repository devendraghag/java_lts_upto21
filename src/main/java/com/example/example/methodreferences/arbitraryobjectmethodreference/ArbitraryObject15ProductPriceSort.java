package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

/** Hard: Product::price feeds a primitive-key extractor used by Comparator.comparingDouble. */
public class ArbitraryObject15ProductPriceSort {
    record Product(String name, double price) {
    }

    public static void main(String[] args) {
        ToDoubleFunction<Product> lambda = product -> product.price();
        ToDoubleFunction<Product> reference = Product::price;
        List<Product> products = List.of(
                new Product("Keyboard", 49.99),
                new Product("Monitor", 199.99),
                new Product("Mouse", 24.50));

        System.out.println("Lambda price for Monitor: " + lambda.applyAsDouble(products.get(1)));
        System.out.println("By ascending price: "
                + products.stream().sorted(Comparator.comparingDouble(reference)).toList());
    }
}
