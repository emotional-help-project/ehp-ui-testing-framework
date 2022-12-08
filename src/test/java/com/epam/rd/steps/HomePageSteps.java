package com.epam.rd.steps;

import com.epam.rd.drivermanager.DriverManager;
import com.epam.rd.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @Given("User is on the HomePage")
    public void openHomePage() {
        homePage.open();
    }

    @When("Clicks on the SignUp link in the header")
    public void clickSignUp() {
        homePage.clickSignUp();
    }

    @And("Clicks on the Login link in the header")
    public void clickLogin() {
        homePage.clickLogin();
    }

    @Then("Validate user successfully logged-in")
    public void validateUserSuccessfullyLoggedIn() {
        System.out.println(homePage.getWelcomeText());
        Assert.assertTrue((homePage.getWelcomeText()).contains("Welcome"));
    }
}
