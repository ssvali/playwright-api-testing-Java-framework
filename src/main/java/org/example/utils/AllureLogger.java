package org.example.utils;

import io.qameta.allure.Allure;

public class AllureLogger {

    public static void attachJson(String name, String json) {
        Allure.addAttachment(name, "application/json",
                json == null ? "" : json, ".json");
    }

    public static void attachText(String name, String text) {
        Allure.addAttachment(name, "text/plain",
                text == null ? "" : text, ".txt");
    }
}
