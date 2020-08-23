Feature: Account creation
  Scenario Outline: Create an account

    Given User is on the authentication page
    When user inputs email into address field
    And  user clicks Create an account button
    When user fills <firstName>, <lastName>, <password>
    And user clicks Register button
    Then success message appears
    And close browser

    Examples:
    |firstName|lastName|password|
    |Stanislaw|Kowalski|admin1  |
    |Piotr    |Nowak   |haslo1  |
