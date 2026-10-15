package com.example.interviewprograms.p35_top_k_frequent_product_names;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 35/50: Top K Frequent Product Names — Medium. Java 8+ standalone example. */
public class TopKFrequentProductNames {
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
        Map<String,Long> counts = orders().stream()
            .filter(o -> o.getStatus().equals("PAID"))
            .flatMap(o -> o.getItems().stream()).map(LineItem::getName)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> top = counts.entrySet().stream()
            .sorted(Comparator.<Map.Entry<String,Long>>comparingLong(Map.Entry::getValue)
                .reversed().thenComparing(Map.Entry::getKey))
            .limit(3).map(e -> e.getKey() + "=" + e.getValue())
            .collect(Collectors.toList());
        System.out.println("Top product-name frequencies: " + top);
    }
}
