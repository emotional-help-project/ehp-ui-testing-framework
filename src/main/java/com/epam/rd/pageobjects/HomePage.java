package com.epam.rd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private static final String URL = "http://5.58.12.93:9090/";
    @FindBy(xpath = "//div[text()='Sign Up']")
    WebElement signUpButton;

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage();
    }
}
