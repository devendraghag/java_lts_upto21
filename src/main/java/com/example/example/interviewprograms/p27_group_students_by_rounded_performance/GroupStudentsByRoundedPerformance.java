package com.example.interviewprograms.p27_group_students_by_rounded_performance;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 27/50: Group Students by Rounded Performance — Medium. Java 8+ standalone example. */
public class GroupStudentsByRoundedPerformance {
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
        Map<String,List<String>> bands = students().stream().collect(
            Collectors.groupingBy(s -> s.average() >= 85 ? "Distinction" :
                 s.average() >= 70 ? "Pass" : "Needs improvement",
                 TreeMap::new, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("Performance bands: " + bands);
        System.out.println("Top student: " + students().stream()
            .max(Comparator.comparingDouble(Student::average)).map(Student::getName).orElse("None"));
    }
}
