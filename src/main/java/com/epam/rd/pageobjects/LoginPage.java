package com.epam.rd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInButton;



}
