package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.net.http.HttpClient;

/**
 * Easy: Demonstrates Http Client Api17 Http11 Version Config in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi17Http11VersionConfig {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        System.out.println("preferredVersion=" + client.version());
    }
}
