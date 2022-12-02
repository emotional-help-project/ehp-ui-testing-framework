Feature: SignUp feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the SignUp button

  Scenario: SignUp with valid data
    Given User enters valid data
      | firstName | test             |
      | lastName  | test             |
      | email     | test%d@test.test |
      | password  | test1@Ttest      |
      | age       | 33               |
    And Selects a gender
    When User click the SignUp button
    Then A successful signup message is displayed

  Scenario: SignUp with empty fields
    Then SignUp button is disabled

  Scenario Outline: SignUp with invalid first name (too short/too long)
    When User enters an invalid first name <firstName>
    And Selects a gender
    Then An error message "* First name length must be equil 2-20 characters" is displayed beneath first name field
    Examples:
      | firstName                                 |
      | "a"                                       |
      | "firstnametoolongtobeusedinoursignupform" |

  Scenario Outline: SignUp with invalid last name (too short/too long)
    When User enters an invalid last name <lastName>
    And Selects a gender
    Then An error message "* Last name length must be equil 2-20 characters" is displayed beneath last name field
    Examples:
      | lastName                                 |
      | "a"                                      |
      | "lastnametoolongtobeusedinoursignupform" |

  Scenario: SignUp with invalid email
    When Entered email is invalid
      | firstName | test                                    |
      | lastName  | firstnametoolongtobeusedinoursignupform |
      | email     | aaa@aaa                                 |
      | password  | test1@Ttest                             |
      | age       | 33                                      |
    And Selects a gender
    Then An error message "* Email address must be valid" beneath email field

  Scenario: SignUp with an already used email
    Given Entered email has an account linked to it
      | firstName | test           |
      | lastName  | test           |
      | email     | test@test.test |
      | password  | test1@Ttest    |
      | age       | 33             |
    And Selects a gender
    When User click the SignUp button
    Then An error label is displayed with message "The user with email test@test.test already exists. Please check credentials."
