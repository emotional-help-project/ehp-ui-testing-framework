package com.epam.rd.steps;

import com.epam.rd.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @When("User clicks on the SignIn button")
    public void userClicksOnTheSignInButton() {
        loginPage.clickLoginButton();
    }

    @Then("Validate login failure message appears")
    public void validateLoginFailureMessageAppears() {
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("Bad credentials"));
    }

    @And("User enters a {string} password")
    public void userEntersAPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Given("User enters an {string} email")
    public void userEntersAnEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("User clicks on password field")
    public void userClicksOnPassword() {
        loginPage.clickOnPasswordField();
    }

    @Then("Validate email error message appears")
    public void validateEmailErrorMessageAppears() {
        Assert.assertEquals(loginPage.getEmailErrorText(), "* Email address must be valid");
    }

    @When("User clicks on email field")
    public void userClicksOnEmailField() {
        loginPage.clickOnEmailField();
    }

    @Then("Validate password error message appears")
    public void validatePasswordErrorMessageAppears() {
        Assert.assertTrue((loginPage.getPsdErrorText()).contains("Password must contain"));
    }
}
