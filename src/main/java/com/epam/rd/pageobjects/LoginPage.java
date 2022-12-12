package com.epam.rd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//app-auth-form//h2")
    WebElement pageName;

    public String getPageName() {
        return pageName.getText();
    }
}
