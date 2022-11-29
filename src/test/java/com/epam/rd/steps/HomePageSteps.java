package com.epam.rd.steps;

import com.epam.rd.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps {
    private final HomePage homePage = new HomePage();

    @Given("User is on the HomePage")
    public void openHomePage() {
        homePage.open();
    }

    @And("Clicks on the SignUp button")
    public void clickSignUp() {
        homePage.clickSignUp();
    }
}
