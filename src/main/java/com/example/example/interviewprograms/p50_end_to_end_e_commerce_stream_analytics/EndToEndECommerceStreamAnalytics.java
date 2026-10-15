package com.example.interviewprograms.p50_end_to_end_e_commerce_stream_analytics;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 50/50: End to End E Commerce Stream Analytics — Advanced. Java 8+ standalone example. */
public class EndToEndECommerceStreamAnalytics {
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


    static class LineItem {
        private final String name;
        private final String category;
        private final int quantity;
        private final double unitPrice;
        LineItem(String name, String category, int quantity, double unitPrice) {
            this.name = name; this.category = category;
            this.quantity = quantity; this.unitPrice = unitPrice;
        }
        String getName() { return name; }
        String getCategory() { return category; }
        int getQuantity() { return quantity; }
        double getUnitPrice() { return unitPrice; }
        double total() { return quantity * unitPrice; }
        @Override public String toString() { return name + " x" + quantity; }
    }
    static class Order {
        private final int id;
        private final String customer;
        private final String region;
        private final String status;
        private final List<LineItem> items;
        Order(int id, String customer, String region, String status, LineItem... items) {
            this.id=id; this.customer=customer; this.region=region;
            this.status=status; this.items=Arrays.asList(items);
        }
        int getId() { return id; }
        String getCustomer() { return customer; }
        String getRegion() { return region; }
        String getStatus() { return status; }
        List<LineItem> getItems() { return items; }
        double total() { return items.stream().mapToDouble(LineItem::total).sum(); }
    }
    static List<Order> orders() {
        return Arrays.asList(
            new Order(201,"Asha","West","PAID",new LineItem("Keyboard","Accessories",2,1500),new LineItem("Mouse","Accessories",1,800)),
            new Order(202,"Ravi","East","PAID",new LineItem("Monitor","Electronics",1,12000)),
            new Order(203,"Asha","West","PAID",new LineItem("Cable","Accessories",3,300)),
            new Order(204,"Neha","South","CANCELLED",new LineItem("Laptop","Electronics",1,55000)),
            new Order(205,"Ravi","East","PAID",new LineItem("Chair","Furniture",2,4500)),
            new Order(206,"Isha","West","PENDING",new LineItem("Desk","Furniture",1,7000),new LineItem("Mouse","Accessories",1,800)),
            new Order(207,"Isha","South","PAID",new LineItem("Monitor","Electronics",1,12000),new LineItem("Keyboard","Accessories",1,1500)),
            new Order(208,"Asha","South","PAID",new LineItem("Lamp","Furniture",2,1000))
        );
    }
    public static void main(String[] args) {
        List<Order> paid = orders().stream().filter(o -> "PAID".equals(o.getStatus()))
            .collect(Collectors.toList());
        double revenue = paid.stream().mapToDouble(Order::total).sum();
        Map<String,Double> byCategory = paid.stream()
            .flatMap(o -> o.getItems().stream())
            .collect(Collectors.groupingBy(LineItem::getCategory, TreeMap::new,
                Collectors.summingDouble(LineItem::total)));
        Map<String,Double> byCustomer = paid.stream().collect(
            Collectors.groupingBy(Order::getCustomer, TreeMap::new,
                Collectors.summingDouble(Order::total)));
        Optional<String> bestCategory = byCategory.entrySet().stream()
            .sorted(Comparator.<Map.Entry<String,Double>>comparingDouble(Map.Entry::getValue)
                .reversed().thenComparing(Map.Entry::getKey))
            .map(Map.Entry::getKey).findFirst();
        Map<String,Integer> unitsByName = paid.stream().flatMap(o -> o.getItems().stream())
            .collect(Collectors.groupingBy(LineItem::getName, TreeMap::new,
                Collectors.summingInt(LineItem::getQuantity)));
        List<String> alerts = products().stream().filter(p -> p.getStock() <= 5)
            .map(Product::getName).sorted().collect(Collectors.toList());
        System.out.println("PAID orders: " + paid.size());
        System.out.println("Revenue: " + revenue);
        System.out.println("Revenue by category: " + byCategory);
        System.out.println("Revenue by customer: " + byCustomer);
        System.out.println("Best category: " + bestCategory.orElse("None"));
        System.out.println("Units by product: " + unitsByName);
        System.out.println("Low-stock alerts: " + alerts);
    }
}
