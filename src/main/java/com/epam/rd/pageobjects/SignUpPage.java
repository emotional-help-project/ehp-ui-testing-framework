package com.epam.rd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//input[@formcontrolname='age']")
    WebElement ageField;
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpFormButton;
    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> genderRadioButtons;

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
}
