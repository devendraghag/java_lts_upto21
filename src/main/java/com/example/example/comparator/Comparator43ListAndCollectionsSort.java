package com.example.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator43ListAndCollectionsSort {
    public static void main(String[] args) {
        Comparator<String> byLength = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());

        List<String> withListSort = new ArrayList<>(List.of("plum", "fig", "pear", "apricot"));
        withListSort.sort(byLength);
        System.out.println("List.sort = " + withListSort);

        List<String> withCollectionsSort = new ArrayList<>(List.of("plum", "fig", "pear", "apricot"));
        Collections.sort(withCollectionsSort, byLength);
        System.out.println("Collections.sort = " + withCollectionsSort);
    }
}
