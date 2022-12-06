package com.epam.rd.steps;

import com.epam.rd.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
}
