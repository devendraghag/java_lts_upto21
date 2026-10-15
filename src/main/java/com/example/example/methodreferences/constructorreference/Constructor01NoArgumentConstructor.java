package com.example.methodreferences.constructorreference;

import java.util.function.Supplier;

/** Easy: ClassName::new matches a no-argument constructor and Supplier<T>. */
public class Constructor01NoArgumentConstructor {
    record Greeting() {
        Greeting {
            System.out.println("Greeting object created");
        }
    }

    public static void main(String[] args) {
        // Lambda version: Supplier.get() calls new Greeting().
        Supplier<Greeting> lambda = () -> new Greeting();
        Supplier<Greeting> reference = Greeting::new;

        lambda.get();
        reference.get();
    }
}
