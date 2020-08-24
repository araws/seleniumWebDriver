Feature: Change user information after login

  Scenario: Change user birthday date, gender and sign up for a newsletter

    Given User is logged in to CodersLab shop
    When User goes to UserInformationPage
    And User changes his birthdate to "05/31/2000"
    And User signs up for our newsletter
    And User saves information
    Then User sees "Information successfully updated."