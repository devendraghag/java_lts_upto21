package com.example.comparable;

import java.time.*;
import java.util.*;

public class Comparable23LocalDateNaturalOrder {

    public static void main(String[] x) {
        System.out.println(List.of(LocalDate.of(2026, 12, 1), LocalDate.of(2025, 5, 2)).stream().sorted().toList());
        // LocalDate.compareTo is called by sorted().
    }
}
