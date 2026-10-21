package com.example.example.interviewprograms.p57_stream_entryset_top_three;

import java.util.HashMap;
import java.util.Map;

/** Additional example: Top Three Map Entries by Value. Standard Java Map only. */
public class StreamEntrySetTopThree {
    public static void main(String[] args) {
        Map<String, Integer> votesByCandidate = new HashMap<>();
        votesByCandidate.put("Asha", 82);
        votesByCandidate.put("Ravi", 95);
        votesByCandidate.put("Mina", 95);
        votesByCandidate.put("Dev", 76);
        votesByCandidate.put("Neha", 88);

        votesByCandidate.entrySet().stream()
                .sorted((first, second) -> {
                    int byVotes = second.getValue().compareTo(first.getValue());
                    return byVotes != 0 ? byVotes : first.getKey().compareTo(second.getKey());
                })
                .limit(3)
                .forEach(entry -> System.out.println(
                        entry.getKey() + " -> " + entry.getValue()));
    }
}
