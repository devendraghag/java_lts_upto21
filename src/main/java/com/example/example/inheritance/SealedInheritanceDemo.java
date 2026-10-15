package com.example.inheritance;

/** Demonstrates sealed inheritance and exhaustive pattern matching (JDK 17/21). */
public class SealedInheritanceDemo {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount("Asha", 1200),
                new BusinessAccount("Ravi", 4500),
                new PremiumBusinessAccount("Mina", 9000)
        };

        for (Account account : accounts) {
            System.out.println(summary(account));
        }
    }

    private static String summary(Account account) {
        return switch (account) {
            case SavingsAccount savings -> "Savings account for " + savings.owner();
            case BusinessAccount business -> "Business account for " + business.owner();
        };
    }

    private sealed interface Account permits SavingsAccount, BusinessAccount {
        String owner();
    }

    private record SavingsAccount(String owner, int balance) implements Account { }

    private static non-sealed class BusinessAccount implements Account {
        private final String owner;
        private final int balance;

        protected BusinessAccount(String owner, int balance) {
            this.owner = owner;
            this.balance = balance;
        }

        @Override
        public String owner() {
            return owner;
        }
    }

    private static final class PremiumBusinessAccount extends BusinessAccount {
        private PremiumBusinessAccount(String owner, int balance) {
            super(owner, balance);
        }
    }
}
