package com.example.methodreferences.constructorreference;

import java.util.function.Supplier;

/** Harder: a constructor reference can target a supertype if the constructed type implements it. */
public class Constructor13PolymorphicFactory {
    interface Shape {
        String description();
    }

    record Circle() implements Shape {
        @Override
        public String description() {
            return "Circle";
        }
    }

    public static void main(String[] args) {
        Supplier<Shape> lambda = () -> new Circle();
        Supplier<Shape> reference = Circle::new;

        System.out.println(lambda.get().description());
        System.out.println(reference.get().description());
    }
}
