package com.example.interviewprograms.p26_count_products_by_category;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 26/50: Count Products by Category — Medium. Java 8+ standalone example. */
public class CountProductsByCategory {
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
        Map<String,Long> counts = products().stream().collect(
            Collectors.groupingBy(Product::getCategory, TreeMap::new, Collectors.counting()));
        System.out.println("Counts: " + counts);
        long outOfStock = products().stream().filter(p -> p.getStock() == 0).count();
        System.out.println("Out of stock products: " + outOfStock);
    }
}
