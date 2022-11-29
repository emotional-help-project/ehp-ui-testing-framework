Feature: SignUp feature for Emotional Help Project

  Background: User is on the HomePage
    Given User is on the HomePage
    And Clicks on the SignUp button

  Scenario: SignUp with valid data
    Given User enters valid data
      | firstName | test           |
      | lastName  | test           |
      | email     | test%d@test.test |
      | password  | testtest       |
      | age       | 33             |

    And Selects a gender
    When User click the SignUp button
    Then User is redirected to the LoginPage