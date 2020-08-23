Feature: Account creation
  Scenario: Create an account

    Given User is on the authentication page
    When user inputs email into address field
    And  user clicks Create an account button
    When user fills Stanislaw, Kowalski, admin1
    And user clicks Register button
    Then success message appears
    And close browser
