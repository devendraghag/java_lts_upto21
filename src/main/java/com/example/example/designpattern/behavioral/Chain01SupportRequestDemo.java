package com.example.designpattern.behavioral;

// Each support handler either solves the request or forwards it to the next handler.
public class Chain01SupportRequestDemo {
    abstract static class Handler {
        private Handler next;
        Handler setNext(Handler value) { next = value; return value; }
        void handle(int level, String issue) {
            if (canHandle(level)) solve(issue);
            else if (next != null) next.handle(level, issue);
            else System.out.println("No handler for " + issue);
        }
        protected abstract boolean canHandle(int level);
        protected abstract void solve(String issue);
    }
    static class HelpDesk extends Handler {
        protected boolean canHandle(int level) { return level == 1; }
        protected void solve(String issue) { System.out.println("Help desk solved: " + issue); }
    }
    static class Technician extends Handler {
        protected boolean canHandle(int level) { return level == 2; }
        protected void solve(String issue) { System.out.println("Technician solved: " + issue); }
    }
    static class Manager extends Handler {
        protected boolean canHandle(int level) { return level >= 3; }
        protected void solve(String issue) { System.out.println("Manager solved: " + issue); }
    }
    public static void main(String[] args) {
        Handler chain = new HelpDesk();
        chain.setNext(new Technician()).setNext(new Manager());
        chain.handle(2, "Laptop issue");
        chain.handle(3, "Urgent account issue");
    }
}
