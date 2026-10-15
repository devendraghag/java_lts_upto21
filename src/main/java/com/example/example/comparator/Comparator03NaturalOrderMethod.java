package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator03NaturalOrderMethod {
    public static void main(String[] args) {
        List<String> words = List.of("pear", "apple", "plum");
        Comparator<String> order = Comparator.naturalOrder();
        System.out.println(words.stream().sorted(order).toList());
        System.out.println("compare pear/apple sign = "
                + Integer.signum(order.compare("pear", "apple")));
    }
}
