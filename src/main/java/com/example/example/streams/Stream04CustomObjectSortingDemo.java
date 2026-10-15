package com.example.streams;

import java.util.Comparator;
import java.util.List;

/** Shows sorting and distinct() with a custom record type. */
public class Stream04CustomObjectSortingDemo {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", 40),
                new Course("SQL", 20),
                new Course("Java", 40),
                new Course("Spring", 35));

        // Records provide equals() and hashCode(), so distinct() recognizes
        // the two Course("Java", 40) values as equal.
        List<Course> uniqueCourses = courses.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Course::hours)
                        .thenComparing(Course::name))
                .toList();

        System.out.println("Unique courses sorted by hours: " + uniqueCourses);
    }

    private record Course(String name, int hours) {
    }
}