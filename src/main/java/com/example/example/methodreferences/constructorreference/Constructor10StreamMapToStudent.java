package com.example.methodreferences.constructorreference;

import java.util.List;

/** Medium: each input String is passed to the matching Student constructor. */
public class Constructor10StreamMapToStudent {
    record Student(String name) {
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ira", "Dev", "Noor");

        // Lambda version: names.stream().map(name -> new Student(name)).toList()
        List<Student> lambdaResult = names.stream()
                .map(name -> new Student(name))
                .toList();
        List<Student> referenceResult = names.stream()
                .map(Student::new)
                .toList();

        System.out.println("Lambda: " + lambdaResult);
        System.out.println("Constructor reference: " + referenceResult);
    }
}
