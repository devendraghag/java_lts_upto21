package com.example.interviewprograms.p46_merge_student_lists_and_resolve_duplicate_ids;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 46/50: Merge Student Lists and Resolve Duplicate IDs — Advanced. Java 8+ standalone example. */
public class MergeStudentListsAndResolveDuplicateIds {
    static class Student {
        private final int roll;
        private final String name, city;
        private final List<Integer> scores;
        Student(int roll, String name, String city, Integer... scores) {
            this.roll=roll; this.name=name; this.city=city;
            this.scores=Arrays.asList(scores);
        }
        int getRoll() {return roll;}
        String getName() {return name;}
        String getCity() {return city;}
        List<Integer> getScores() {return scores;}
        double average() {return scores.stream().mapToInt(Integer::intValue).average().orElse(0);}
        @Override public String toString(){return name + " (" + city + ")";}
    }
    static List<Student> students() {
        return Arrays.asList(
            new Student(1,"Aarav","Pune",80,90,70),
            new Student(2,"Diya","Mumbai",95,85,90),
            new Student(3,"Rohan","Pune",60,75,65),
            new Student(4,"Meera","Mumbai",90,90,90),
            new Student(5,"Ishaan","Nashik",50,70,60),
            new Student(6,"Sara","Pune",85,80,90)
        );
    }
    public static void main(String[] args) {
        List<Student> batch1 = students().subList(0,4);
        List<Student> batch2 = Arrays.asList(
            new Student(2,"Diya Updated","Mumbai",100,95,95),
            new Student(7,"Kabir","Nashik",75,80,80));
        Map<Integer,Student> byRoll = Stream.concat(batch1.stream(),batch2.stream())
            .collect(Collectors.toMap(Student::getRoll, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingDouble(Student::average))));
        List<String> ranked = byRoll.values().stream()
            .sorted(Comparator.comparingDouble(Student::average).reversed())
            .map(s -> s.getRoll() + ":" + s.getName())
            .collect(Collectors.toList());
        System.out.println("Merged unique students: " + byRoll.size());
        System.out.println("Ranked: " + ranked);
    }
}
