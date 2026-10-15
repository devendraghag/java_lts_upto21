package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** MEDIUM 13/17: try-with-resources (Java 7+) closes a resource automatically. */
public class ExceptionHandling13TryWithResources {
    static class DemoResource implements AutoCloseable {
        DemoResource() {
            System.out.println("Resource opened");
        }

        void use() {
            System.out.println("Resource used");
        }

        @Override
        public void close() {
            System.out.println("Resource closed automatically");
        }
    }

    public static void main(String[] args) {
        try (DemoResource resource = new DemoResource()) {
            resource.use();
        }
        System.out.println("After the resource scope");
    }
}
