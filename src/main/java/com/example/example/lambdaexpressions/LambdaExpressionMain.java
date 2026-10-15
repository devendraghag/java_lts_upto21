package com.example.lambdaexpressions;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


//Anonymous class
/**
 * Easy: Demonstrates Lambda Expression Main in the Lambda Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
interface Transaction1 {
    public void withDrawAmount(int amt);  // Updated method name
}

public class LambdaExpressionMain {       // Updated class name
    public static void main(String[] args) {
        Transaction1 transactionImpl = new Transaction1() { // Updated variable name
            @Override
            public void withDrawAmount(int amt) {
                System.out.print("Amount withdraw " + amt);
            }
        };
        transactionImpl.withDrawAmount(1111);
    }
}
