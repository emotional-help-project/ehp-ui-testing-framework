Feature: SignIn feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the Login link in the header

  Scenario Outline: Login with valid credentials
    Given User enters "<email>" email, "<password>" password for login
    When User clicks on the SignIn button
    Then Validate user successfully logged-in
    Examples:
    |email                 |  password     |
    |test10@yahoo.com      |  Test1234*    |

  Scenario Outline: Login with invalid credentials
    Given User enters "<email>" email, "<password>" password for login
    When User clicks on the SignIn button
    Then Validate login failure message appears
    Examples:
      |email                 |  password     |
      |test@yahoo.com        |  Tet1234*     |



