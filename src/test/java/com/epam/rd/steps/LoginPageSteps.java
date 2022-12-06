package com.epam.rd.steps;

import com.epam.rd.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Then("Login page is displayed")
    public void isLoginPageDisplayed() {
        Assert.assertEquals(loginPage.getPageName(), "Sign in"
                , "User is not on LogIn page");
    }
}
