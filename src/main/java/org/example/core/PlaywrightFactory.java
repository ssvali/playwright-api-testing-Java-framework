package org.example.core;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import java.util.Map;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<APIRequestContext> requestContext = new ThreadLocal<>();

    public static APIRequestContext getRequestContext(String baseUrl) {

        if (requestContext.get() == null) {

            Playwright pw = Playwright.create();
            playwright.set(pw);

            requestContext.set(
                    pw.request().newContext(
                            new APIRequest.NewContextOptions()
                                    .setBaseURL(baseUrl)
                                    .setExtraHTTPHeaders(Map.of("Content-Type", "application/json"))
                    )
            );
        }

        return requestContext.get();
    }

    public static void close() {
        if (requestContext.get() != null) {
            requestContext.get().dispose();
            requestContext.remove();
        }

        if (playwright.get() != null) {
            playwright.get().close();
            playwright.remove();
        }

        TokenManager.clear();
    }
}
