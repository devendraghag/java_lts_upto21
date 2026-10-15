package com.example.staticimport;

import static com.example.staticimport.ProjectDefaults.APPLICATION_NAME;
import static com.example.staticimport.ProjectDefaults.DEFAULT_TIMEOUT_SECONDS;
import static com.example.staticimport.ProjectDefaults.Mode;
import static com.example.staticimport.ProjectDefaults.Mode.SAFE;
import static com.example.staticimport.ProjectDefaults.formatSetting;

/** Demonstrates static imports of application constants, methods, and enum values. */
public class StaticImportCustomMembersDemo {
    public static void main(String[] args) {
        System.out.println("Application: " + APPLICATION_NAME);
        System.out.println(formatSetting("timeoutSeconds", DEFAULT_TIMEOUT_SECONDS));
        System.out.println("Mode: " + SAFE);
        System.out.println("Another mode via imported nested type: " + Mode.FAST);
    }
}
