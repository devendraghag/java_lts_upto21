package com.example.comparator;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Comparator32AppointmentComparator {
    record Appointment(LocalDate date, int sequence) {}

    public static void main(String[] args) {
        List<Appointment> appointments = List.of(
                new Appointment(LocalDate.of(2026, 6, 3), 2),
                new Appointment(LocalDate.of(2026, 6, 1), 1),
                new Appointment(LocalDate.of(2026, 6, 3), 1));

        // Reverse only the date key; same-day sequence still increases.
        Comparator<Appointment> newestDateFirst = Comparator
                .comparing(Appointment::date)
                .reversed()
                .thenComparingInt(Appointment::sequence);
        System.out.println(appointments.stream().sorted(newestDateFirst).toList());
    }
}
