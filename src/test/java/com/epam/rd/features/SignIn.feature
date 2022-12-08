Feature: SignIn feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the Login link in the header

  Scenario Outline: Login with valid credentials
    Given User enters an "<email>" email
    And User enters a "<password>" password
    When User clicks on the SignIn button
    Then Validate user successfully logged-in
    Examples:
    |email                 |  password     |
    |test10@yahoo.com      |  Test1234*    |


  Scenario Outline: Login with invalid credentials
    Given User enters an "<email>" email
    And User enters a "<password>" password
    When User clicks on the SignIn button
    Then Validate login failure message appears
    Examples:
      |email                 |  password     |
      |test@yahoo.com        |  Tet1234*     |


  Scenario Outline: Login with invalid email
    Given User enters an "<email>" email
    When User clicks on password field
    Then Validate email error message appears
    Examples:
      |email          |
      |test@com       |


  Scenario Outline: Login with invalid password
    Given User enters a "<password>" password
    When User clicks on email field
    Then Validate password error message appears
    Examples:
      |password      |
      |test          |


