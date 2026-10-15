package com.example.collectionconversions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** List to Map conversions using a value as key, or list position as key. */
public class ListToMapDemo {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring", "SQL");

        Map<String, Integer> lengthByCourse = courses.stream()
                .collect(Collectors.toMap(
                        course -> course,
                        String::length,
                        (firstLength, duplicateLength) -> firstLength,
                        LinkedHashMap::new));

        Map<Integer, String> courseByIndex = IntStream.range(0, courses.size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> index,
                        courses::get,
                        (firstCourse, duplicateCourse) -> firstCourse,
                        LinkedHashMap::new));

        System.out.println("Course to name length: " + lengthByCourse);
        System.out.println("Index to course: " + courseByIndex);

        // The merge function handles duplicate keys. Here, duplicate course names are counted.
        List<String> repeatedCourses = List.of("Java", "SQL", "Java");
        Map<String, Integer> courseCounts = repeatedCourses.stream()
                .collect(Collectors.toMap(
                        course -> course,
                        course -> 1,
                        Integer::sum,
                        LinkedHashMap::new));
        System.out.println("Course counts: " + courseCounts);
    }
}