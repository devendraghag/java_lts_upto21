package com.example.primitivestreams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Demonstrates IntStream, LongStream, and DoubleStream construction,
 * intermediate operations, conversions, and terminal operations through
 * JDK 21. No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/primitivestreams/PrimitiveStreamsExamples.java
 *   java -cp out com.example.primitivestreams.PrimitiveStreamsExamples
 */
public class PrimitiveStreamsExamples {
    public static void main(String[] args) {
        createPrimitiveStreams();
        intStreamOperations();
        longStreamOperations();
        doubleStreamOperations();
        convertBetweenStreamTypes();
        terminalOperationExamples();
    }

    private static void createPrimitiveStreams() {
        System.out.println("== Create primitive streams ==");

        IntStream ints = IntStream.range(1, 5); // end is exclusive
        LongStream longs = LongStream.rangeClosed(1, 4); // end is inclusive
        DoubleStream doubles = DoubleStream.of(1.25, 2.5, 3.75);
        System.out.println("IntStream.range: " + Arrays.toString(ints.toArray()));
        System.out.println("LongStream.rangeClosed: " + Arrays.toString(longs.toArray()));
        System.out.println("DoubleStream.of: " + Arrays.toString(doubles.toArray()));

        int[] sourceArray = {2, 4, 6};
        System.out.println("IntStream.of(array): " + Arrays.toString(IntStream.of(sourceArray).toArray()));
    }

    private static void intStreamOperations() {
        System.out.println("\n== IntStream operations ==");

        int sum = IntStream.rangeClosed(1, 8)
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .sum();
        System.out.println("filter even, square, sum: " + sum);

        System.out.println("mapToObj: " + IntStream.of(3, 5, 8)
                .mapToObj(value -> "n=" + value).toList());
        System.out.println("boxed: " + IntStream.of(3, 5, 8).boxed().toList());
        System.out.println("takeWhile: " + IntStream.of(1, 2, 3, 1, 2)
                .takeWhile(value -> value < 3).boxed().toList());
    }

    private static void longStreamOperations() {
        System.out.println("\n== LongStream operations ==");

        long product = LongStream.rangeClosed(1, 5)
                .filter(value -> value % 2 != 0)
                .reduce(1L, (left, right) -> left * right);
        System.out.println("product of odd values 1..5 using reduce: " + product);

        System.out.println("mapToObj: " + LongStream.of(1_000_000_000L, 2_000_000_000L)
                .mapToObj(value -> value + " bytes").toList());
        System.out.println("boxed: " + LongStream.of(4L, 5L, 6L).boxed().toList());
    }

    private static void doubleStreamOperations() {
        System.out.println("\n== DoubleStream operations ==");

        DoubleStream measurements = DoubleStream.of(12.5, 15.0, 18.5, 20.0);
        System.out.println("filter and map: " + Arrays.toString(
                measurements.filter(value -> value >= 15.0).map(value -> value * 1.1).toArray()));

        System.out.println("boxed: " + DoubleStream.of(1.5, 2.5, 3.5).boxed().toList());
        System.out.println("mapToObj: " + DoubleStream.of(1.25, 2.5)
                .mapToObj(value -> String.format(java.util.Locale.ROOT, "%.2f", value)).toList());
    }

    private static void convertBetweenStreamTypes() {
        System.out.println("\n== Convert between primitive and object streams ==");

        // IntStream can widen to long/double without an explicit mapper.
        System.out.println("IntStream.asLongStream: "
                + Arrays.toString(IntStream.of(1, 2, 3).asLongStream().toArray()));
        System.out.println("IntStream.asDoubleStream: "
                + Arrays.toString(IntStream.of(1, 2, 3).asDoubleStream().toArray()));

        // Other conversions use mapToX. Narrowing to int is explicit.
        System.out.println("LongStream.mapToInt: "
                + Arrays.toString(LongStream.of(10L, 20L).mapToInt(Math::toIntExact).toArray()));
        System.out.println("LongStream.asDoubleStream: "
                + Arrays.toString(LongStream.of(10L, 20L).asDoubleStream().toArray()));
        System.out.println("DoubleStream.mapToInt: "
                + Arrays.toString(DoubleStream.of(1.9, 2.1).mapToInt(value -> (int) value).toArray()));
        System.out.println("DoubleStream.mapToLong: "
                + Arrays.toString(DoubleStream.of(1.9, 2.1).mapToLong(Math::round).toArray()));

        System.out.println("object Stream to IntStream: "
                + Arrays.toString(java.util.stream.Stream.of("a", "abcd").mapToInt(String::length).toArray()));
    }

    private static void terminalOperationExamples() {
        System.out.println("\n== Common terminal operations ==");

        System.out.println("Int summary: " + IntStream.of(4, 8, 2, 10).summaryStatistics());
        System.out.println("Long count / min / max: " + LongStream.of(5L, 9L, 2L).count()
                + " / " + LongStream.of(5L, 9L, 2L).min().orElseThrow()
                + " / " + LongStream.of(5L, 9L, 2L).max().orElseThrow());
        System.out.println("Double sum / average: " + DoubleStream.of(1.5, 2.5, 3.0).sum()
                + " / " + DoubleStream.of(1.5, 2.5, 3.0).average().orElse(0.0));

        StringBuilder collected = IntStream.rangeClosed(1, 4).collect(
                StringBuilder::new,
                (builder, value) -> builder.append(value).append(' '),
                (left, right) -> left.append(right));
        System.out.println("IntStream.collect into StringBuilder: " + collected);

        System.out.print("forEach: ");
        LongStream.of(2L, 4L, 6L).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
