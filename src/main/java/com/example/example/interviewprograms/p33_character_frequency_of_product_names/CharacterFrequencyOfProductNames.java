package com.example.interviewprograms.p33_character_frequency_of_product_names;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 33/50: Character Frequency of Product Names — Medium. Java 8+ standalone example. */
public class CharacterFrequencyOfProductNames {
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
        Map<Character,Long> freq = products().stream().map(Product::getName)
            .flatMapToInt(String::chars).map(Character::toLowerCase)
            .filter(c -> c != ' ')
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        System.out.println("Letter counts: " + freq);
        System.out.println("Count of e: " + freq.getOrDefault('e',0L));
    }
}
