package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * Easy: Demonstrates Http Client Api19 Body Publishers And Handlers in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi19BodyPublishersAndHandlers {
    public static void main(String[] args) {
        HttpRequest.BodyPublisher text = HttpRequest.BodyPublishers.ofString("hello");
        HttpRequest.BodyPublisher bytes = HttpRequest.BodyPublishers
                .ofByteArray("java".getBytes(StandardCharsets.UTF_8));
        HttpRequest.BodyPublisher empty = HttpRequest.BodyPublishers.noBody();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://example.com/items"))
                .POST(text)
                .build();

        HttpResponse.BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
        HttpResponse.BodyHandler<byte[]> asBytes = HttpResponse.BodyHandlers.ofByteArray();
        HttpResponse.BodyHandler<Void> discard = HttpResponse.BodyHandlers.discarding();

        System.out.println("method=" + request.method());
        System.out.println("lengths=" + text.contentLength() + ","
                + bytes.contentLength() + "," + empty.contentLength());
        System.out.println("handlersReady="
                + (asString != null && asBytes != null && discard != null));
    }
}
