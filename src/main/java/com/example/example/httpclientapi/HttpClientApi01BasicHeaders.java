package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


/*
 * Interview level: Beginner.
 * Feature combination/topic: HttpRequest headers.
 *
 * Notes:
 * - Kept in the JDK11 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Http Client Api01 Basic Headers in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi01BasicHeaders {
    public static void main(String[] args) throws Exception {
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create("https://example.com"))
                .header("Accept", "application/json")
                .build();
        System.out.println(request.headers().map());
        System.out.println(request.headers().firstValue("Accept").orElse("No Accept header"));
    }
}