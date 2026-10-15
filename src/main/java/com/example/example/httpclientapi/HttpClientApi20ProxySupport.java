package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient;

/**
 * Easy: Demonstrates Http Client Api20 Proxy Support in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi20ProxySupport {
    public static void main(String[] args) {
        ProxySelector proxy = ProxySelector.of(new InetSocketAddress("localhost", 8080));
        HttpClient client = HttpClient.newBuilder().proxy(proxy).build();

        ProxySelector configured = client.proxy()
                .orElseThrow(() -> new IllegalStateException("Proxy missing"));
        System.out.println("proxy=" + configured.select(java.net.URI.create("https://example.com")));
    }
}
