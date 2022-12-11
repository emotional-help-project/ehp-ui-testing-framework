package com.epam.rd.pageobjects;

import com.epam.rd.util.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private static final String URL = ConfigUtil.getHomePageURL();
    @FindBy(xpath = "//div[text()='Sign Up']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[text()='Sign In']")
    WebElement loginButton;

    By welcomeText = By.xpath("//li[text()='Profile']");

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage();
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return new LoginPage();
    }

    public String getWelcomeText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(welcomeText))
                .getText();
    }
}
