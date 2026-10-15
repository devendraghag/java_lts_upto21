package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


/*
 * Interview level: Intermediate.
 * Feature combination/topic: HttpClient timeout.
 *
 * Notes:
 * - Kept in the JDK11 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Http Client Api09 Connect Timeout Config in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi09ConnectTimeoutConfig {
    public static void main(String[] args) throws Exception {
        java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder().connectTimeout(java.time.Duration.ofSeconds(2)).build();
        System.out.println(client.connectTimeout().isPresent());
    }
}