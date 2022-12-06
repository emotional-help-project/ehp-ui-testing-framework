Feature: SignUp feature for Emotional Help Project

  Background: Open SignUp Page
    Given User is on the HomePage
    And Clicks on the SignUp link in the header

  Scenario: SignUp with valid data
    Given User enters valid data
      | firstName | test                  |
      | lastName  | test                  |
      | email     | testemail%d@test.test |
      | password  | test1@Ttest           |
      | age       | 33                    |
    And Selects a gender
    When User click the SignUp form button
    Then A successful signup message is displayed

  Scenario: SignUp with empty fields
    Then SignUp button is disabled

  Scenario Outline: SignUp with invalid first name (too short/too long)
    When User enters an invalid first name "<firstName>"
    And Selects a gender
    Then An error message "* First name length must be equal to 2-20 characters" is displayed beneath first name field
    Examples:
      | firstName                               |
      | a                                       |
      | firstnametoolongtobeusedinoursignupform |

  Scenario Outline: SignUp with invalid last name (too short/too long)
    When User enters an invalid last name "<lastName>"
    And Selects a gender
    Then An error message "* Last name length must be equal to 2-20 characters" is displayed beneath last name field
    Examples:
      | lastName                               |
      | a                                      |
      | lastnametoolongtobeusedinoursignupform |

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
    Given User enters an email that has an account linked to it
      | firstName | test           |
      | lastName  | test           |
      | email     | test@test.test |
      | password  | test1@Ttest    |
      | age       | 33             |
    And Selects a gender
    When User click the SignUp form button
    Then An error label is displayed with message "The user with email test@test.test already exists. Please check credentials."

  Scenario Outline: SignUp with invalid age (negative/0/lest than 5/greater 150)
    Given User enters an invalid age "<age>"
    And Selects a gender
    Then An error message "* Minimum accepted age is 5 years, maximum accepted age is 150" is displayed beneath age field
    Examples:
      | age |
      | -10 |
      | 0   |
      | 4   |
      | 170 |

  Scenario Outline: SignUp with invalid password (<8 characters/no uppercase letter/no lowercase letter/no digit/no special character)
    Given User enters an invalid password "<password>"
    And Selects a gender
    Then The following error message is displayed
      | * Password must contain at least 1 digit, 1 lowercase, 1 uppercase, 1 special character (! @ # &), minimum length is 8 characters |
    Examples:
      | password      |
      | secret        |
      | superSecret1  |
      | supersecret1! |
      | SUPERSECRET1! |
      | superSecret!  |

  Scenario: SignUp with different password and confirmation password
    Given User enters different password and confirmation password
      | superSecret1!    |
      | notsuperSecret1! |
    And Selects a gender
    Then An error message "* Both passwords must be equal" is displayed beneath confirmation password field