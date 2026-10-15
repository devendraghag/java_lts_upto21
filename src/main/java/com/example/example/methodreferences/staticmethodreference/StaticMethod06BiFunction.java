package com.example.methodreferences.staticmethodreference;

import java.util.function.BinaryOperator;

/** Medium: Integer.sum takes two ints and returns int, matching BinaryOperator<Integer>. */
public class StaticMethod06BiFunction {
    public static void main(String[] args) {
        BinaryOperator<Integer> lambda = (left, right) -> Integer.sum(left, right);
        BinaryOperator<Integer> reference = Integer::sum;

        System.out.println(lambda.apply(10, 20));
        System.out.println(reference.apply(100, 200));
    }
}
