package com.example.methodreferences.constructorreference;

import java.util.function.Supplier;

/** Hard: constructor references can be passed through generic factory methods. */
public class Constructor15GenericFactoryMethod {
    record Session(String label) {
        Session() {
            this("new session");
        }
    }

    static <T> T create(Supplier<T> constructor) {
        return constructor.get();
    }

    public static void main(String[] args) {
        // Lambda equivalent: create(() -> new Session())
        Session session = create(Session::new);
        StringBuilder builder = create(StringBuilder::new);

        System.out.println(session);
        System.out.println(builder.append("generic factory"));
    }
}
