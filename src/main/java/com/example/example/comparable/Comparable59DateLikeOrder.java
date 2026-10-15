package com.example.comparable;

import java.time.*;
import java.util.*;

public class Comparable59DateLikeOrder {

    public static void main(String[] x) {
        LocalDate start = LocalDate.of(2026, 1, 1), middle = LocalDate.of(2026, 6, 1), end = LocalDate.of(2026, 12, 31);
        System.out.println(start.compareTo(middle) < 0 && middle.compareTo(end) < 0);
        System.out.println(List.of(end, start, middle).stream().sorted().toList());
        // LocalDate has chronological natural order.
    }
}
