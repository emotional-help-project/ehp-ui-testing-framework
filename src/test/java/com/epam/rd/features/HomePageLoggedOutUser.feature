Feature: HomePage for logged out user

  Background: Open HomePage
    Given Logged out user is on the HomePage

  Scenario: Anonymous user can open SignUp page
    When User clicks the SignUp link in the header
    Then SignUp page is displayed

  Scenario: Anonymous user can open LoginPage page
    When User clicks the Log In link in the header
    Then Login page is displayed

  Scenario: Contact info is displayed on the HomePage
    Then Contact info is displayed
      | phoneNumber  | +38 (096) 487 18 93 |
      | city         | Lviv                |
      | emailAddress | info@gmail.com      |

  Scenario: List of services is displayed on the HomePage
    Then A list of offered services is displayed

  Scenario: List of trainings is displayed on the HomePage
    Then A list of offered trainings is displayed