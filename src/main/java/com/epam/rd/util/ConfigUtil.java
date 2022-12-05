package com.epam.rd.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    private static final String path = "src/main/resources/config.properties";
    private static final Properties properties = readPropertiesFile();

    private static Properties readPropertiesFile() {
        Properties props = new Properties();
        try (InputStream inputStream = new FileInputStream(ConfigUtil.path)) {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found");
        }
        return props;
    }

    public static String getHomePageURL() {
        return properties.getProperty("ehp.homepage.url");
    }
}
