package com.example.objectinitialization;

/** Demonstrates the builder pattern for an object with optional values. */
public class BuilderInitializationDemo {
    private static final class Request {
        private final String endpoint;
        private final int timeoutSeconds;
        private final boolean retry;

        private Request(Builder builder) {
            endpoint = builder.endpoint;
            timeoutSeconds = builder.timeoutSeconds;
            retry = builder.retry;
        }

        private static final class Builder {
            private final String endpoint;
            private int timeoutSeconds = 30;
            private boolean retry;

            private Builder(String endpoint) {
                if (endpoint == null || endpoint.isBlank()) {
                    throw new IllegalArgumentException("Endpoint is required");
                }
                this.endpoint = endpoint;
            }

            private Builder timeoutSeconds(int timeoutSeconds) {
                if (timeoutSeconds <= 0) {
                    throw new IllegalArgumentException("Timeout must be positive");
                }
                this.timeoutSeconds = timeoutSeconds;
                return this;
            }

            private Builder retry(boolean retry) {
                this.retry = retry;
                return this;
            }

            private Request build() {
                return new Request(this);
            }
        }

        @Override
        public String toString() {
            return "Request{endpoint='" + endpoint + "', timeoutSeconds=" + timeoutSeconds
                    + ", retry=" + retry + "}";
        }
    }

    public static void main(String[] args) {
        Request request = new Request.Builder("/orders")
                .timeoutSeconds(10)
                .retry(true)
                .build();
        System.out.println(request);
    }
}
