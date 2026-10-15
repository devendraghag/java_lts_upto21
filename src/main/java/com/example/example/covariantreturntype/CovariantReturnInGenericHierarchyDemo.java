package com.example.covariantreturntype;

import java.lang.reflect.Method;

/** Covariant return with generics and the compiler-generated bridge method. */
public class CovariantReturnInGenericHierarchyDemo {
    public static void main(String[] args) {
        Box<Dog> box = new DogBox();
        Dog dog = box.get(); // Generic substitution gives callers a Dog return type.
        System.out.println("Retrieved: " + dog.name());

        for (Method method : DogBox.class.getDeclaredMethods()) {
            System.out.println(method.getName() + " returns "
                    + method.getReturnType().getSimpleName()
                    + ", bridge=" + method.isBridge());
        }
    }

    private static class Box<T> {
        T get() { return null; }
    }

    private static final class DogBox extends Box<Dog> {
        @Override
        Dog get() {
            return new Dog("Pip");
        }
    }

    private record Dog(String name) {
    }
}
