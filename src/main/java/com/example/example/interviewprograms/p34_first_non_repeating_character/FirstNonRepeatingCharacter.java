package com.example.interviewprograms.p34_first_non_repeating_character;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 34/50: First Non Repeating Character — Medium. Java 8+ standalone example. */
public class FirstNonRepeatingCharacter {
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
        Product p = new Product("X1","swiss","Demo",10,1);
        Map<Character,Long> counts = p.getName().chars().mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Optional<Character> firstUnique = counts.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey).findFirst();
        System.out.println("Counts: " + counts);
        System.out.println("First unique: " + firstUnique.map(String::valueOf).orElse("None"));
    }
}
