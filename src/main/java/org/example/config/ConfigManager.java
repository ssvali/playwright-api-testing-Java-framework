package org.example.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();
    static String config = System.getProperty("config","dev").toUpperCase();
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/configs/"+config+".properties");
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}

