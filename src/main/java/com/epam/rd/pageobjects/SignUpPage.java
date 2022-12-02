package com.epam.rd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@formcontrolname='age']")
    WebElement ageField;
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpFormButton;
    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> genderRadioButtons;
    @FindBy(xpath = "//small[contains(text(), 'First')]")
    WebElement firstNameErrorMessage;
    @FindBy(xpath = "//small[contains(text(), 'Last')]")
    WebElement lastNameErrorMessage;
    @FindBy(xpath = "//small[contains(text(), 'Email')]")
    WebElement emailErrorMessage;
    By emailErrorLabel = By.xpath("//p[@class='error__message']");
    By signUpConfirmationLabel = By.xpath("//p[@class='success__message']");

    public SignUpPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage confirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
        return this;
    }

    public SignUpPage enterAge(String age) {
        ageField.sendKeys(age);
        return this;
    }

    public LoginPage clickSignUpFormButton() {
        signUpFormButton.click();
        return new LoginPage();
    }

    public SignUpPage clickRandomGenderRadioButton() {
        genderRadioButtons.get(new Random().nextInt(genderRadioButtons.size())).click();
        return this;
    }

    public boolean isSignUpButtonDisabled() {
        return signUpFormButton.getAttribute("disabled") != null;
    }

    public String getConfirmationMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(signUpConfirmationLabel))
                .getText();
    }

    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessage() {
        return lastNameErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getUsedEmailErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(emailErrorLabel))
                .getText();
    }
}
