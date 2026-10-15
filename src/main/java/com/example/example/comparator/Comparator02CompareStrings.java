package com.example.comparator;

import java.util.Comparator;

public class Comparator02CompareStrings {
    public static void main(String[] args) {
        Comparator<String> order = Comparator.naturalOrder();
        System.out.println("apple vs pear = " + Integer.signum(order.compare("apple", "pear")));
        System.out.println("pear vs apple = " + Integer.signum(order.compare("pear", "apple")));
        System.out.println("same text = " + Integer.signum(order.compare("pear", "pear")));
    }
}
