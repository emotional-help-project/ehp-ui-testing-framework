Feature: SignIn feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the Login link in the header

  Scenario: Login with valid credentials
    Given User enters an "test10@yahoo.com" email
    Given User enters a "Test1234*" password
    When User clicks on the SignIn button
    Then Validate user successfully logged-in


  Scenario: Login with invalid credentials
    Given User enters an "test@yahoo.com" email
    Given User enters a "Test12344!" password
    When User clicks on the SignIn button
    Then Validate login failure message appears


  Scenario: Login with invalid email
    Given User enters an "test@com" email
    When User clicks on password field
    Then Validate email error message appears


  Scenario: Login with invalid password
    Given User enters a "test" password
    When User clicks on email field
    Then Validate password error message appears
