package com.epam.rd.steps;

import com.epam.rd.pageobjects.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @Given("Logged out user is on the HomePage")
    public void openHomePage() {
        homePage.open();
    }

    @When("User clicks the SignUp link in the header")
    public void clickSignUp() {
        homePage.clickSignUp();
    }

    @When("User clicks the Log In link in the header")
    public void clickLogIn() {
        homePage.clickLogIn();
    }

    @Then("Contact info is displayed")
    public void isContactInfoDisplayed(DataTable dataTable) {
        Map<String, String> contacts = dataTable.asMap();
        Assert.assertTrue(homePage.isContactInformationDisplayed(), "Contact info is not displayed");
        Assert.assertEquals(homePage.getPhoneNumber(), contacts.get("phoneNumber"), "Wrong phone number");
        Assert.assertEquals(homePage.getCity(), contacts.get("city"), "Wrong city");
        Assert.assertEquals(homePage.getEmailAddress(), contacts.get("emailAddress"), "Wrong email address");
    }

    @Then("A list of offered services is displayed")
    public void areServicesDisplayed() {
        Assert.assertTrue(homePage.areServicesDisplayed(), "Services are not displayed on homepage");
        Assert.assertTrue(homePage.getNumberOfServicesOffered() >= 1, "There are no offered services");
    }

    @Then("A list of offered trainings is displayed")
    public void areTrainingsDisplayed() {
        Assert.assertTrue(homePage.areTrainignsDisplayed(), "Trainings are not displayed on homepage");
        Assert.assertTrue(homePage.getNumberOfTrainingsOffered() >= 1, "There are no offered trainings");
    }
}
