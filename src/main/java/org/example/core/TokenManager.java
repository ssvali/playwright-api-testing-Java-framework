package org.example.core;


import org.example.api.AuthApi;

public class TokenManager {

    private static final ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);

    public static String getToken() {
        if (token.get() == null) {
            token.set(new AuthApi().createToken());
        }
        return token.get();
    }

    public static void clear() {
        token.remove();
    }
}

