package com.epam.rd.pageobjects;

import com.epam.rd.util.ConfigUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private static final String URL = ConfigUtil.getHomePageURL();
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
