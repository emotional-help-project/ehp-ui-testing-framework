package com.epam.rd.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    private static final String path = "src/main/resources/config.properties";
    private static final Properties properties = readPropertiesFile();

    private static Properties readPropertiesFile() {
        Properties props = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(ConfigUtil.path)) {
            props.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public static String getHomePageURL() {
        return properties.getProperty("ehp.homepage.url");
    }
}
