package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

/**
 * Easy: Demonstrates Http Client Api18 Web Socket Client in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi18WebSocketClient {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public CompletionStage<?> onText(WebSocket socket, CharSequence data, boolean last) {
                System.out.println("text=" + data + ", last=" + last);
                return null;
            }
        };

        WebSocket.Builder builder = client.newWebSocketBuilder()
                .header("User-Agent", "JDK11-learning-client");
        URI endpoint = URI.create("wss://example.com/events");

        // A real connection is asynchronous:
        // builder.buildAsync(endpoint, listener).thenCompose(ws -> ws.sendText("hello", true));
        listener.onText(null, "offline-message", true);
        System.out.println("webSocketEndpoint=" + endpoint);
        System.out.println("builderReady=" + (builder != null));
    }
}
