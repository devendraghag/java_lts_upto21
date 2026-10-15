package com.example.terminaloperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Harder: partitioningBy always produces true and false groups, with a downstream collector. */
public class TerminalOperationPractice15Partitioning {
    record Applicant(String name, int score) {
    }

    public static void main(String[] args) {
        List<Applicant> applicants = List.of(
                new Applicant("Asha", 82),
                new Applicant("Ben", 61),
                new Applicant("Mina", 94),
                new Applicant("Dev", 72));

        Map<Boolean, List<String>> namesByResult = applicants.stream().collect(
                Collectors.partitioningBy(
                        applicant -> applicant.score() >= 75,
                        Collectors.mapping(Applicant::name, Collectors.toList())));

        System.out.println("Passed: " + namesByResult.get(true));
        System.out.println("Needs more practice: " + namesByResult.get(false));
    }
}
