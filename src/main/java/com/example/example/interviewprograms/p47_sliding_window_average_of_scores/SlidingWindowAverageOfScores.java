package com.example.interviewprograms.p47_sliding_window_average_of_scores;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.math.*;

/** Program 47/50: Sliding Window Average of Scores — Advanced. Java 8+ standalone example. */
public class SlidingWindowAverageOfScores {
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
        Student student = new Student(9,"Tester","Pune",60,70,80,90,100);
        List<Integer> scores = student.getScores();
        int width = 3;
        List<Double> rolling = IntStream.range(0, scores.size() - width + 1)
            .mapToDouble(start -> IntStream.range(start,start+width)
                .map(scores::get).average().orElse(0))
            .boxed().collect(Collectors.toList());
        System.out.println("Student: " + student.getName());
        System.out.println("Rolling averages: " + rolling);
    }
}
