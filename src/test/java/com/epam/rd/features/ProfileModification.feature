Feature: Profile information modification feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the Login link in the header
    And User enters an "test10@yahoo.com" email
    And User enters a "Test1234* " password
    When User clicks on the SignIn button

  Scenario: Edit user's firstname
#    Given User enters an "<email>" email
#    Given User enters a "<password>" password
#    When User clicks on the SignIn button
#    Then Validate user successfully logged-in