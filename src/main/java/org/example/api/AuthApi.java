package org.example.api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.Constants;
import org.example.config.ConfigManager;
import org.example.core.BaseApi;
import org.example.models.AuthRequest;
import org.example.utils.JsonUtils;

public class AuthApi extends BaseApi {

    public String createToken() {

        AuthRequest payload = new AuthRequest(
                ConfigManager.get("username"),
                ConfigManager.get("password")
        );

        var response = post(Constants.AUTH_ENDPOINT, JsonUtils.toJson(payload));
        String jsonBody = response.text();
        JsonObject obj = JsonParser.parseString(jsonBody).getAsJsonObject();
        return obj.get("token").getAsString();
    }
}

