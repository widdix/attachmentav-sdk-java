package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.AsyncDownloadScanRequest;
import com.attachmentav.model.Whoami;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class VerifyCallback {

    private static String API_KEY = "<API_KEY_PLACEHOLDER>";

    // To make your server runmning on localhost accessible from the Internet, we recommend to use ngrok.
    // 1. Install and configure it as described here: https://ngrok.com/docs/getting-started
    // 2. In your terminal, run:
    // ngrok http 8081
    // 3. Insert the ngrok URL (e.g. https://42d3a8497f95.ngrok-free.app) below:
    private static String CALLBACK_URL = "<CALLBACK_URL_PLACEHOLDER>";

    private static String PUBLIC_KEY_PEM = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyLoZzjo1cQV9ZN2TH/al\n" +
            "rxWiQ3u/ndT0HMrLMdBTVO3Tz1nUjLt6SqKZsN8dQhvPoEjfyhCTEg7MPWopG3n0\n" +
            "cf3NRxtoeXy/Z62b1zdUd426kMuKOQP8Yy6cxa/RtK2tkHCnTGxjfvNmMK+m68sF\n" +
            "msilR88LnIN71my4cG8bIDGDftWublvKAEOWhxSECYn1XEtyrQL5lm8HFnHdE9ys\n" +
            "56xTJkdr5Mmkvanrnd/hXzTHzjruGcLvbjciI82+Z335AzYgJcnmH4/zsBuyPL2F\n" +
            "JSfQF9NsPaTJuQgkw1usAKBQcujcEriYUDNWgTe1a+LOnCEMb+9mAYw8lMRYRd3C\n" +
            "BwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    public static void main(String[] args) throws IOException, ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey(API_KEY);
        AttachmentAvApi api = new AttachmentAvApi();
        {
            Whoami result = api.whoamiGet();
            System.err.println("Replace <TENANT_ID_PLACEHOLDER> with " + result.getTenantId() + ", and uncomment this block");
            System.exit(1);
        }
        String TENANT_ID = "<TENANT_ID_PLACEHOLDER>";

        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/", exchange -> {
            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            try {
                if (CallbackSignatureX509.verify(System.currentTimeMillis(), PUBLIC_KEY_PEM, exchange.getRequestHeaders().getFirst("x-timestamp"), TENANT_ID, CALLBACK_URL, body, exchange.getRequestHeaders().getFirst("x-signature"))) {
                    exchange.sendResponseHeaders(204, -1);
                    exchange.close();
                    System.out.println("Received valid callback: " + body);
                } else {
                    exchange.sendResponseHeaders(403, -1);
                    exchange.close();
                    System.err.println("Received invalid callback: " + body);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                server.stop(1);
            }
        });

        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server running on port 8081");

        AsyncDownloadScanRequest request = new AsyncDownloadScanRequest();
        request.setCallbackUrl(CALLBACK_URL);
        request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        api.scanAsyncDownloadPost(request);
        System.out.println("Async download submitted");
    }
}
