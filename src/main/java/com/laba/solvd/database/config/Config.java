package com.laba.solvd.database.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum Config {
    DRIVER("driver"),
    URL("url"),
    USERNAME("username"),
    PASSWORD("password"),
    POOL_SIZE("pool_size");

    private final String key;
    private String value;
    private static final Properties properties;
    private static final String file = "src/main/resources/config.properties";

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to configure database connection");
        }
    }

    Config(String key) {
        this.key = key;
    }

    Config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return properties.getProperty(key, value);
    }
}
