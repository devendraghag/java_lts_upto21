package com.example.interviewprograms.p29_preserve_sorting_in_a_linkedhashmap;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 29/50: Preserve Sorting in a LinkedHashMap — Medium. Java 8+ standalone example. */
public class PreserveSortingInALinkedhashmap {
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
        Map<String,Double> bySku = products().stream()
            .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
            .collect(Collectors.toMap(Product::getSku, Product::getPrice,
                (oldValue,newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("SKU price ranking:");
        bySku.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
