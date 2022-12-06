package com.epam.rd.steps;

import com.epam.rd.pageobjects.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class SignUpPageSteps {

    private final SignUpPage signUpPage = new SignUpPage();

    @Given("User enters valid data")
    public void enterValidData(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @When("User click the SignUp form button")
    public void clickSignUpFormButton() {
        signUpPage.clickSignUpFormButton();
    }

    @When("Selects a gender")
    public void selectGender() {
        signUpPage.clickRandomGenderRadioButton();
    }

    @Then("SignUp button is disabled")
    public void isSignupButtonDisabled() {
        Assert.assertTrue(signUpPage.isSignUpButtonDisabled(), "SignUp button should be disabled");
    }

    @Then("A successful signup message is displayed")
    public void getConfirmationMessage() {
        Assert.assertTrue(signUpPage.getConfirmationMessage().contains("You registered successfully")
                , "Correct SignUp confirmation message should be displayed");
    }

    @Then("An error message {string} is displayed beneath first name field")
    public void getFirstNameErrorMessage(String expectedFirstNameErrorMessage) {
        Assert.assertEquals(signUpPage.getFirstNameErrorMessage(), expectedFirstNameErrorMessage
                , "Incorrect first name error message should be displayed");
    }

    @Then("An error message {string} is displayed beneath last name field")
    public void getLastNameErrorMessage(String expectedLastNameErrorMessage) {
        Assert.assertEquals(signUpPage.getLastNameErrorMessage(), expectedLastNameErrorMessage
                , "Incorrect last name error message should be displayed");
    }

    @When("Entered email is invalid")
    public void enterInvalidEmail(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error message {string} beneath email field")
    public void getEmailErrorMessage(String expectedEmailErrorMessage) {
        Assert.assertEquals(signUpPage.getEmailErrorMessage(), expectedEmailErrorMessage
                , "Incorrect email error message should be displayed");
    }

    @When("User enters an email that has an account linked to it")
    public void enterAnAlreadyUsedEmail(DataTable dataTable) {
        fillFormFromDataTable(dataTable);
    }

    @Then("An error label is displayed with message {string}")
    public void getUsedEmailErrorMessage(String expectedEmailErrorMessage) {
        Assert.assertEquals(signUpPage.getUsedEmailErrorMessage(), expectedEmailErrorMessage
                , "Already used email message should be displayed");
    }

    @When("User enters an invalid first name {string}")
    public void enterInvalidFirstName(String firstName) {
        signUpPage.enterFirstName(firstName);
    }

    @When("User enters an invalid last name {string}")
    public void enterInvalidLastName(String lastName) {
        signUpPage.enterLastName(lastName);
    }

    @Given("User enters an invalid age {string}")
    public void enterAge(String age) {
        signUpPage.enterAge(age);
    }

    @Then("An error message {string} is displayed beneath age field")
    public void anErrorMessageIsDisplayedBeneathAgeField(String expectedAgeErrorMessage) {
        Assert.assertEquals(signUpPage.getAgeErrorMessage(), expectedAgeErrorMessage
                , "Invalid age message should be displayed");
    }

    @Given("User enters an invalid password {string}")
    public void enterInvalidPassword(String password) {
        signUpPage.enterPassword(password);
    }

    @Then("The following error message is displayed")
    public void getInvalidPasswordErrorMessage(DataTable dataTable) {
        String expectedErrorMessage = dataTable.asList().get(0);
        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), expectedErrorMessage
                , "Invalid password message should be displayed");
    }

    @Given("User enters different password and confirmation password")
    public void enterDifferentPasswordAndConfirmationPassword(DataTable dataTable) {
        List<String> passwords = dataTable.asList();
        signUpPage.enterPassword(passwords.get(0))
                .confirmPassword(passwords.get(1));
    }

    @Then("An error message {string} is displayed beneath confirmation password field")
    public void getConfirmationPasswordErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(signUpPage.getConfirmationPasswordErrorMessage(), expectedErrorMessage
                , "Both passwords must be equal message should be displayed");
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
