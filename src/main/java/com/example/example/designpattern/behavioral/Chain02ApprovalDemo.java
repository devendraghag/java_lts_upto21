package com.example.designpattern.behavioral;

// An expense request moves through approvers until one has enough authority.
public class Chain02ApprovalDemo {
    abstract static class Approver {
        private Approver next;
        Approver setNext(Approver value) { next = value; return value; }
        void approve(int amount) {
            if (canApprove(amount)) System.out.println(getClass().getSimpleName() + " approved Rs " + amount);
            else if (next != null) next.approve(amount);
            else System.out.println("No approver for Rs " + amount);
        }
        protected abstract boolean canApprove(int amount);
    }
    static class TeamLead extends Approver { protected boolean canApprove(int amount) { return amount <= 1000; } }
    static class Manager extends Approver { protected boolean canApprove(int amount) { return amount <= 10000; } }
    static class Director extends Approver { protected boolean canApprove(int amount) { return amount <= 100000; } }
    public static void main(String[] args) {
        Approver chain = new TeamLead();
        chain.setNext(new Manager()).setNext(new Director());
        chain.approve(500);
        chain.approve(5000);
        chain.approve(50000);
    }
}
