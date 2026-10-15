package com.example.abstractclass;

/** Abstract methods can use access modifiers; implementations cannot reduce visibility. */
public class AbstractClass11ProtectedAccessDemo {
    public static void main(String[] args) {
        System.out.println(new BasicAuthenticator().authenticate("guest"));
    }

    private abstract static class Authenticator {
        protected abstract boolean authenticate(String username);
    }

    private static final class BasicAuthenticator extends Authenticator {
        @Override
        public boolean authenticate(String username) {
            return "guest".equals(username);
        }
    }
}
