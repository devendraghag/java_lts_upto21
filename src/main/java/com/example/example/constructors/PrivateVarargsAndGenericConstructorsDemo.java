package com.example.constructors;

import java.util.List;

/** Private constructors, static factories, varargs, and generic constructors. */
public class PrivateVarargsAndGenericConstructorsDemo {
    public static void main(String[] args) {
        AccessToken token = AccessToken.create("sample-token");
        CourseSchedule schedule = new CourseSchedule("Java", "SQL", "Concurrency");
        GenericBox box = new GenericBox(42);

        System.out.println("Factory-created token: " + token.value());
        System.out.println("Varargs subjects: " + schedule.subjects());
        System.out.println("Value from generic constructor: " + box.value());
    }

    private static class AccessToken {
        private final String value;
        private AccessToken(String value) { this.value = value; }
        static AccessToken create(String value) { return new AccessToken(value); }
        String value() { return value; }
    }

    private static class CourseSchedule {
        private final List<String> subjects;
        CourseSchedule(String... subjects) { this.subjects = List.of(subjects); }
        List<String> subjects() { return subjects; }
    }

    private static class GenericBox {
        private final Object value;
        <T> GenericBox(T value) { this.value = value; }
        Object value() { return value; }
    }
}
