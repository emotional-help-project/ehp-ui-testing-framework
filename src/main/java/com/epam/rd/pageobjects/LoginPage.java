package com.epam.rd.pageobjects;

import com.epam.rd.util.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;

    By loginErrorLabel = By.xpath("//div[@class='cointainer__error']");

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        signInButton.click();
    }

    public String getHomePageURL(){
        return ConfigUtil.getHomePageURL();
    }

    public String getLoginErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(loginErrorLabel))
                .getText();
    }
}
