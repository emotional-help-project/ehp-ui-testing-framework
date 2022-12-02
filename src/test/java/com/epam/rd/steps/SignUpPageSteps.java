package com.epam.rd.steps;

import com.epam.rd.pageobjects.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

public class SignUpPageSteps {

    private final SignUpPage signUpPage = new SignUpPage();

    @Given("User enters valid data")
    public void enterValidData(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @When("User click the SignUp button")
    public void clickSignUpFormButton() {
        signUpPage.clickSignUpFormButton();
    }

    @And("Selects a gender")
    public void selectGender() {
        signUpPage.clickRandomGenderRadioButton();
    }

    @Then("SignUp button is disabled")
    public void isSignupButtonDisabled() {
        Assert.assertTrue(signUpPage.isSignUpButtonDisabled());
    }

    @Then("A successful signup message is displayed")
    public void getConfirmationMessage() {
        Assert.assertTrue(signUpPage.getConfirmationMessage().contains("You register successfully"));
    }

    @Given("Entered first name is too short")
    public void enterTooShortFirstName(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error message {string} is displayed beneath first name field")
    public void getFirstNameErrorMessage(String expectedFirstNameErrorMessage) {
        Assert.assertEquals(signUpPage.getFirstNameErrorMessage(), expectedFirstNameErrorMessage);
    }

    @Given("Entered first name is too long")
    public void enterTooLongFirstName(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Given("Entered last name is too short")
    public void enterTooShortLastName(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error message {string} is displayed beneath last name field")
    public void getLastNameErrorMessage(String expectedLastNameErrorMessage) {
        Assert.assertEquals(signUpPage.getLastNameErrorMessage(), expectedLastNameErrorMessage);
    }

    @Given("Entered last name is too long")
    public void enterTooLongLastName(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @When("Entered email is invalid")
    public void enterInvalidEmail(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error message {string} beneath email field")
    public void getEmailErrorMessage(String expectedEmailErrorMessage) {
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), expectedEmailErrorMessage);
    }

    @When("Entered email has an account linked to it")
    public void enterAnAlreadyUsedEmail(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error label is displayed with message {string}")
    public void getUsedEmailErrorMessage(String expectedEmailErrorMessage) {
        Assert.assertEquals(signUpPage.getUsedEmailErrorMessage(), expectedEmailErrorMessage);
    }

    public void fillFormFromDataTable(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        signUpPage.enterFirstName(data.get("firstName"))
                .enterLastName(data.get("lastName"))
                .enterEmail(String.format(data.get("email"), new Random().nextInt(1000)))
                .enterPassword(data.get("password"))
                .confirmPassword(data.get("password"))
                .enterAge(data.get("age"));
    }
}
