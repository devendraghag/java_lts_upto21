package com.example.primitivestreammapping;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Demonstrates primitive Stream mapping operations through JDK 21.
 * mapMultiToInt/Long/Double were added in JDK 16. No preview or incubator APIs.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/primitivestreammapping/PrimitiveStreamMappingExamples.java
 *   java -cp out com.example.primitivestreammapping.PrimitiveStreamMappingExamples
 */
public class PrimitiveStreamMappingExamples {
    public static void main(String[] args) {
        mapToLongExample();
        mapToDoubleExample();
        flatMapToIntExample();
        flatMapToLongExample();
        flatMapToDoubleExample();
        mapMultiToIntExample();
        mapMultiToLongExample();
        mapMultiToDoubleExample();
    }

    // One input produces exactly one primitive value.
    private static void mapToLongExample() {
        System.out.println("== mapToLong ==");
        long totalLength = List.of("Java", "Stream", "JDK").stream()
                .mapToLong(String::length)
                .sum();
        System.out.println("total text length: " + totalLength);
    }

    private static void mapToDoubleExample() {
        System.out.println("\n== mapToDouble ==");
        double average = List.of(70, 85, 92).stream()
                .mapToDouble(Integer::doubleValue)
                .average().orElse(0.0);
        System.out.println("average score: " + average);
    }

    // Each input supplies a primitive stream; flatMapToX flattens the results.
    private static void flatMapToIntExample() {
        System.out.println("\n== flatMapToInt ==");
        int[] codePoints = List.of("Hi", "Java").stream()
                .flatMapToInt(String::codePoints)
                .toArray();
        System.out.println("flattened code points: " + IntStream.of(codePoints).boxed().toList());
    }

    private static void flatMapToLongExample() {
        System.out.println("\n== flatMapToLong ==");
        List<List<Long>> batches = List.of(List.of(1_000L, 2_000L), List.of(3_000L), List.of(4_000L));
        long[] values = batches.stream()
                .flatMapToLong(batch -> batch.stream().mapToLong(Long::longValue))
                .toArray();
        System.out.println("flattened long values: " + LongStream.of(values).boxed().toList());
    }

    private static void flatMapToDoubleExample() {
        System.out.println("\n== flatMapToDouble ==");
        List<List<Double>> groups = List.of(List.of(18.5, 19.0), List.of(20.25, 21.0));
        double[] values = groups.stream()
                .flatMapToDouble(group -> group.stream().mapToDouble(Double::doubleValue))
                .toArray();
        System.out.println("flattened measurements: " + java.util.Arrays.toString(values));
    }

    // Each input can emit zero or more primitive values to the supplied consumer.
    private static void mapMultiToIntExample() {
        System.out.println("\n== mapMultiToInt (JDK 16+) ==");
        List<Integer> vowels = List.of("Java", "Stream").stream()
                .mapMultiToInt((word, output) -> word.codePoints().forEach(codePoint -> {
                    if ("AEIOUaeiou".indexOf(codePoint) >= 0) output.accept(codePoint);
                }))
                .boxed().toList();
        System.out.println("vowel code points: " + vowels);
    }

    private static void mapMultiToLongExample() {
        System.out.println("\n== mapMultiToLong (JDK 16+) ==");
        List<Long> lengths = List.of("cat", "elephant").stream()
                .mapMultiToLong((word, output) -> {
                    output.accept(word.length());
                    output.accept(word.length() * 1_000L);
                })
                .boxed().toList();
        System.out.println("length and scaled length: " + lengths);
    }

    private static void mapMultiToDoubleExample() {
        System.out.println("\n== mapMultiToDouble (JDK 16+) ==");
        double sum = List.of(10.0, -2.0, 20.0).stream()
                .mapMultiToDouble((reading, output) -> {
                    if (reading > 0) {
                        output.accept(reading);
                        output.accept(reading * 1.1);
                    }
                })
                .sum();
        System.out.println("positive readings plus 10% adjusted values: " + sum);
    }
}
