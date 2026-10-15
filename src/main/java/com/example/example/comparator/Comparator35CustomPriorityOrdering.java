package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator35CustomPriorityOrdering {
    enum Status { NEW, IN_PROGRESS, BLOCKED, DONE }

    public static void main(String[] args) {
        List<Status> statuses = List.of(Status.DONE, Status.BLOCKED, Status.NEW, Status.IN_PROGRESS);
        Comparator<Status> workflowOrder = Comparator.comparingInt((Status status) -> switch (status) {
            case BLOCKED -> 0;
            case IN_PROGRESS -> 1;
            case NEW -> 2;
            case DONE -> 3;
        });
        System.out.println(statuses.stream().sorted(workflowOrder).toList());
    }
}
