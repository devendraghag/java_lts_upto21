package com.example.interviewprograms.p42_compose_dynamic_product_search_predicates;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 42/50: Compose Dynamic Product Search Predicates — Advanced. Java 8+ standalone example. */
public class ComposeDynamicProductSearchPredicates {
    static class Product {
        private final String sku, name, category;
        private final double price;
        private final int stock;
        Product(String sku, String name, String category, double price, int stock) {
            this.sku=sku; this.name=name; this.category=category;
            this.price=price; this.stock=stock;
        }
        String getSku() {return sku;}
        String getName() {return name;}
        String getCategory() {return category;}
        double getPrice() {return price;}
        int getStock() {return stock;}
        @Override public String toString(){return name + " (" + category + ")";}
    }
    static List<Product> products() {
        return Arrays.asList(
            new Product("P1","Mouse","Accessories",800,25),
            new Product("P2","Keyboard","Accessories",1500,10),
            new Product("P3","Monitor","Electronics",12000,5),
            new Product("P4","Laptop","Electronics",55000,0),
            new Product("P5","Desk","Furniture",7000,8),
            new Product("P6","Chair","Furniture",4500,4),
            new Product("P7","Cable","Accessories",300,80),
            new Product("P8","Lamp","Furniture",1000,12)
        );
    }
    public static void main(String[] args) {
        Predicate<Product> affordable = p -> p.getPrice() <= 5000;
        Predicate<Product> inStock = p -> p.getStock() > 0;
        Predicate<Product> accessory = p -> "Accessories".equals(p.getCategory());
        Predicate<Product> search = affordable.and(inStock).and(accessory);
        List<String> found = products().stream().filter(search)
            .map(Product::getName).sorted().collect(Collectors.toList());
        System.out.println("Affordable in-stock accessories: " + found);
        long missingStock = products().stream().filter(inStock.negate()).count();
        System.out.println("Out of stock: " + missingStock);
        long affordableOrAccessory = products().stream().filter(affordable.or(accessory)).count();
        System.out.println("Affordable OR accessory: " + affordableOrAccessory);
    }
}
