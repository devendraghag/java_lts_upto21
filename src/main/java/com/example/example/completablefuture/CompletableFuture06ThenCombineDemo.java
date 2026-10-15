package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

/** Run independent tasks and combine both results when they are ready. */
public class CompletableFuture06ThenCombineDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> price = CompletableFuture.supplyAsync(() -> 80);
        CompletableFuture<Integer> shipping = CompletableFuture.supplyAsync(() -> 10);

        // These tasks are independent, so they can run at the same time.
        CompletableFuture<String> receipt = price
                .thenCombine(shipping, (itemPrice, shippingCost) ->
                        "Order total: " + (itemPrice + shippingCost));

        System.out.println(receipt.join());
    }
}
