package com.example.example.helloworldways;

/** Java 16: stores the greeting in a record and prints its message component. */
public class HelloWorld17RecordMessage {
    public static void main(String[] args) {
        Greeting greeting = new Greeting("Hello", "World");
        System.out.println(greeting.text());
    }
    private record Greeting(String salutation, String name) {
        private String text() { return salutation + ", " + name + "!"; }
    }
}
