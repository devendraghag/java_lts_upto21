package com.example.functionalinterfaces.binaryinterfaces;

import java.util.List;
import java.util.function.BinaryOperator;

/** Pattern 20: BinaryOperator combines two same-typed values, such as in reduce. */
public class BinaryOperatorPattern20_Reduce {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = Integer::sum;
        int total = List.of(10, 20, 30, 40).stream().reduce(0, add);
        System.out.println("Total: " + total);
    }
}