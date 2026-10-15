package com.example.lambdaexpressions;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


@FunctionalInterface
/**
 * Easy: Demonstrates Lambda Expression Main1 in the Lambda Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
interface Transaction2 { 
    void withDrawAmount(int amt);  // Single abstract method
}

public class LambdaExpressionMain1 { 
    public static void main(String[] args) {
        Transaction2 transactionImpl = (amt) -> System.out.println("Amount withdraw " + amt);
        transactionImpl.withDrawAmount(1111);
    }
}
