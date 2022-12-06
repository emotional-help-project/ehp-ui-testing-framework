package com.epam.rd.pageobjects;

import com.epam.rd.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.Duration;

public abstract class BasePage {

    private static final int TIMEOUT_IN_SECONDS = 5;

    protected WebDriver driver;

    protected BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT_IN_SECONDS), this);
    }
}
