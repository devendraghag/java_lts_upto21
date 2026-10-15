package com.example.methodreferences.instancemethodreference;

import java.util.function.Supplier;

/** Easy: object::instanceMethod captures this particular object; Supplier has no inputs. */
public class InstanceMethod01Supplier {
    static class Greeter {
        String greeting() {
            return "Hello from a specific Greeter";
        }
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Supplier<String> lambda = () -> greeter.greeting();
        Supplier<String> reference = greeter::greeting;

        System.out.println(lambda.get());
        System.out.println(reference.get());
    }
}
