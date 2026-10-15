package com.example.staticimport;

/** Public static members used by the custom static-import examples. */
public final class ProjectDefaults {
    public static final int DEFAULT_TIMEOUT_SECONDS = 30;
    public static final String APPLICATION_NAME = "LearningApp";

    private ProjectDefaults() {
        // Utility class: do not create instances.
    }

    public static String formatSetting(String name, Object value) {
        return name + " = " + value;
    }

    public enum Mode {
        SAFE,
        FAST
    }
}
