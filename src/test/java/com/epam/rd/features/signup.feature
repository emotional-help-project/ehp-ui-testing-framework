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

  Scenario: SignUp with invalid first name (too short)
    When Entered first name is too short
      | firstName | a                |
      | lastName  | test             |
      | email     | test%d@test.test |
      | password  | test1@Ttest      |
      | age       | 33               |
    Then An error message "* First name length must be equil 2-20 characters" is displayed beneath first name field

  Scenario: SignUp with invalid first name (too long)
    When Entered first name is too long
      | firstName | firstnametoolongtobeusedinoursignupform |
      | lastName  | test                                    |
      | email     | test%d@test.test                        |
      | password  | test1@Ttest                             |
      | age       | 33                                      |
    Then An error message "* First name length must be equil 2-20 characters" is displayed beneath first name field

  Scenario: SignUp with invalid last name (too short)
    Given Entered last name is too short
      | firstName | test             |
      | lastName  | a                |
      | email     | test%d@test.test |
      | password  | test1@Ttest      |
      | age       | 33               |
    Then An error message "* Last name length must be equil 2-20 characters" is displayed beneath last name field

  Scenario: SignUp with invalid last name (too long)
    Given Entered last name is too long
      | firstName | test                                    |
      | lastName  | firstnametoolongtobeusedinoursignupform |
      | email     | test%d@test.test                        |
      | password  | test1@Ttest                             |
      | age       | 33                                      |
    Then An error message "* Last name length must be equil 2-20 characters" is displayed beneath last name field

  Scenario: SignUp with invalid email
    When Entered email is invalid
      | firstName | test                                    |
      | lastName  | firstnametoolongtobeusedinoursignupform |
      | email     | aaa@aaa                                 |
      | password  | test1@Ttest                             |
      | age       | 33                                      |
    Then An error message "* Email address must be valid" beneath email field

#  Scenario: SignUp with an already used email
