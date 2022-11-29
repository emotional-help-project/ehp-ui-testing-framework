package com.epam.rd.steps;

import com.epam.rd.pageobjects.SignUpPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.Random;

public class SignUpPageSteps {
    private final SignUpPage signUpPage = new SignUpPage();

    @Given("User enters valid data")
    public void userEntersValidData(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        signUpPage.enterFirstName(data.get("firstName"))
                .enterLastName(data.get("lastName"))
                .enterEmail(String.format(data.get("email"), new Random().nextInt(1000)))
                .enterPassword(data.get("password"))
                .enterAge(data.get("age"));
    }

    @When("User click the SignUp button")
    public void clickSignUpFormButton() {
        signUpPage.clickSignUpFormButton();
    }

    @And("Selects a gender")
    public void selectGender() {
        signUpPage.clickRandomGenderRadioButton();
    }
}
