package com.example.methodreferences.constructorreference;

/** Medium: three constructor inputs need a matching custom functional interface. */
public class Constructor07ThreeArgumentConstructor {
    record Employee(int id, String name, String department) {
    }

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        R apply(A first, B second, C third);
    }

    public static void main(String[] args) {
        TriFunction<Integer, String, String, Employee> lambda =
                (id, name, department) -> new Employee(id, name, department);
        TriFunction<Integer, String, String, Employee> reference = Employee::new;

        System.out.println(lambda.apply(101, "Neha", "Finance"));
        System.out.println(reference.apply(102, "Ravi", "IT"));
    }
}
