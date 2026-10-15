package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Control coupling: a caller passes a flag that directs which behavior the
 * called module will perform.
 */
public class CouplingType03Control {
    static class ReportService {
        void printReport(boolean includePrivateDetails) {
            System.out.println("Public report data");
            if (includePrivateDetails) {
                System.out.println("Private report data");
            }
        }
    }

    public static void main(String[] args) {
        ReportService service = new ReportService();
        service.printReport(false); // The caller controls the branch.
        service.printReport(true);
    }
}
