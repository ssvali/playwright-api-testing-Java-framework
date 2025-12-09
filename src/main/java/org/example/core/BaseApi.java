package org.example.core;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.example.Constants;
import org.example.config.ConfigManager;
import org.example.utils.LoggerUtil;
import org.slf4j.Logger;

public class BaseApi {
    protected final Logger logger = LoggerUtil.getLogger(BaseApi.class);
    protected final APIRequestContext request;

    public BaseApi() {
        this.request = PlaywrightFactory.getRequestContext(ConfigManager.get("base.url"));
    }

    // Automatically include token except for /auth
    private RequestOptions withAuth(String endpoint, RequestOptions options) {
        if (!endpoint.equals(Constants.AUTH_ENDPOINT)) {
            String token = TokenManager.getToken();
            options.setHeader("Cookie", "token=" + token);
        }
        return options;
    }

    protected APIResponse get(String endpoint) {
        logger.info("GET Request to endpoint: {}", endpoint);
        return request.get(endpoint, withAuth(endpoint, RequestOptions.create()));
    }

    protected APIResponse post(String endpoint, String body) {
        return request.post(endpoint, withAuth(endpoint,
                RequestOptions.create().setData(body)));
    }

    protected APIResponse put(String endpoint, String body) {
        return request.put(endpoint, withAuth(endpoint,
                RequestOptions.create().setData(body)));
    }

    protected APIResponse delete(String endpoint) {
        return request.delete(endpoint, withAuth(endpoint, RequestOptions.create()));
    }

}
