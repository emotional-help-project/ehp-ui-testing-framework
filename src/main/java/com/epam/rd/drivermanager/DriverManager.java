package com.epam.rd.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

public class DriverManager {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(WebDriver::quit);
        webDriverThreadLocal.remove();
    }
}
