package com.example.lambdaexpressions;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


//normal class
/**
 * Easy: Demonstrates Lambda Expression1 in the Lambda Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
interface Transaction {
    public void withDraw(int amt);
}
class WithDraw implements Transaction {

    @Override
    public void withDraw(int amt) {
        System.out.print("Amount withdraw" + amt);
    }
}
public class LambdaExpression1 {
    public static void main(String[] args) {
        WithDraw obj = new WithDraw();
        obj.withDraw(1111);
    }
}
