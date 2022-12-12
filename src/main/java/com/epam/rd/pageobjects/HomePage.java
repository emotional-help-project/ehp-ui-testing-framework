package com.epam.rd.pageobjects;

import com.epam.rd.util.ConfigUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    private static final String URL = ConfigUtil.getHomePageURL();
    @FindBy(xpath = "//div[@class='registr']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[text()='Sign In']")
    WebElement logInButton;

    @FindBy(xpath = "//div[@class='number item']/span")
    WebElement phoneNumber;
    @FindBy(xpath = "//div[@class='location item']/span")
    WebElement city;
    @FindBy(xpath = "//div[@class='email item']/span")
    WebElement emailAddress;

    @FindBy(xpath = "//li[@class='course_item']")
    List<WebElement> services;

    @FindBy(xpath = "//li[@class='card_item']")
    List<WebElement> trainings;

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage();
    }

    public LoginPage clickLogIn() {
        logInButton.click();
        return new LoginPage();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getEmailAddress() {
        return emailAddress.getText();
    }

    public int getNumberOfServicesOffered() {
        return services.size();
    }

    public int getNumberOfTrainingsOffered() {
        return trainings.size();
    }

    public boolean isContactInformationDisplayed() {
        return phoneNumber.isDisplayed() && city.isDisplayed() && emailAddress.isDisplayed();
    }

    public boolean areServicesDisplayed() {
        for (WebElement service : services) {
            if (!service.isDisplayed()) return false;
        }
        return true;
    }

    public boolean areTrainignsDisplayed() {
        for (WebElement training : trainings) {
            if (!training.isDisplayed()) return false;
        }
        return true;
    }
}
