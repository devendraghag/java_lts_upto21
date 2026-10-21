package com.example.example.interviewprograms.p58_stream_entryset_collect_filtered;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** Additional example: Filter Entries into a New Map. Standard Java Map only. */
public class StreamEntrySetCollectFiltered {
    public static void main(String[] args) {
        Map<String, Integer> scoresByStudent = new LinkedHashMap<>();
        scoresByStudent.put("Asha", 91);
        scoresByStudent.put("Ravi", 64);
        scoresByStudent.put("Mina", 78);
        scoresByStudent.put("Dev", 55);

        Map<String, Integer> passingScores = scoresByStudent.entrySet().stream()
                .filter(entry -> entry.getValue() >= 70)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (first, second) -> first,
                        LinkedHashMap::new));

        passingScores.forEach((name, score) ->
                System.out.println(name + " passed with " + score));
    }
}
