package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Temporal cohesion: tasks are grouped because they happen at the same time
 * (application startup), not because they perform the same business job.
 */
public class CohesionType05Temporal {
    static class ApplicationStartup {
        void start() {
            loadConfiguration();
            openLog();
            warmCache();
        }

        private void loadConfiguration() {
            System.out.println("Startup: configuration loaded");
        }

        private void openLog() {
            System.out.println("Startup: log opened");
        }

        private void warmCache() {
            System.out.println("Startup: cache warmed");
        }
    }

    public static void main(String[] args) {
        new ApplicationStartup().start();
    }
}
