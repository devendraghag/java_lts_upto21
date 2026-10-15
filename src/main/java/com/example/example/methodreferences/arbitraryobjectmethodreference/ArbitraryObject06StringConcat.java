package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.BinaryOperator;

/** Medium: BinaryOperator<String> is a BiFunction whose two input and result types match. */
public class ArbitraryObject06StringConcat {
    public static void main(String[] args) {
        // The first input is the receiver; the second is concat's argument.
        BinaryOperator<String> lambda = (left, right) -> left.concat(right);
        BinaryOperator<String> reference = String::concat;

        System.out.println(lambda.apply("Java", " 21"));
        System.out.println(reference.apply("Method", " reference"));
    }
}
