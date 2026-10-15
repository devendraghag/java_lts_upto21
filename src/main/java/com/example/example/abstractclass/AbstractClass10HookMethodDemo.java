package com.example.abstractclass;

/** A hook is an overridable concrete method that supplies an optional step. */
public class AbstractClass10HookMethodDemo {
    public static void main(String[] args) {
        new BasicReport().generate();
        new AuditedReport().generate();
    }

    private abstract static class Report {
        public final void generate() {
            System.out.println("Build report");
            beforePublish();
            System.out.println("Publish report");
        }

        protected void beforePublish() { /* Optional extension point. */ }
    }

    private static final class BasicReport extends Report { }

    private static final class AuditedReport extends Report {
        @Override
        protected void beforePublish() { System.out.println("Write audit entry"); }
    }
}
