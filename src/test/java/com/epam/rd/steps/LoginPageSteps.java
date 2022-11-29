package com.epam.rd.steps;

import com.epam.rd.pageobjects.LoginPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Then("User is redirected to the LoginPage")
    public void verifyUserIsOnLoginPage() {
        Assert.assertEquals(loginPage.getButtonText(), "Sign in");
    }
}
