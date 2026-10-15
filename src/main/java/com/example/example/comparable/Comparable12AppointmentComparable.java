package com.example.comparable;

import java.time.LocalDate;
import java.util.List;

public class Comparable12AppointmentComparable {
    record Appointment(LocalDate date, int sequence) implements Comparable<Appointment> {
        @Override
        public int compareTo(Appointment other) {
            int byDate = date.compareTo(other.date);
            // Sequence only breaks ties when two appointments share a date.
            return byDate != 0 ? byDate : Integer.compare(sequence, other.sequence);
        }
    }

    public static void main(String[] args) {
        List<Appointment> appointments = List.of(
                new Appointment(LocalDate.of(2026, 6, 3), 2),
                new Appointment(LocalDate.of(2026, 6, 1), 1),
                new Appointment(LocalDate.of(2026, 6, 3), 1));
        System.out.println(appointments.stream().sorted().toList());
    }
}
