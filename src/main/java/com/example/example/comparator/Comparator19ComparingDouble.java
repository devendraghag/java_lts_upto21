package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator19ComparingDouble {
    record Measurement(double value) {}

    public static void main(String[] args) {
        List<Measurement> measurements = List.of(
                new Measurement(Double.NaN),
                new Measurement(2.5),
                new Measurement(0.0),
                new Measurement(-0.0));

        // Double.compare orders negative zero before positive zero and NaN after finite values.
        Comparator<Measurement> byValue = Comparator.comparingDouble(Measurement::value);
        System.out.println(measurements.stream().sorted(byValue).toList());
    }
}
