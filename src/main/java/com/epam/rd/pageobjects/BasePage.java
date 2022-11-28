package com.epam.rd.pageobjects;

import com.epam.rd.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    protected WebDriver driver;

    protected BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
}
