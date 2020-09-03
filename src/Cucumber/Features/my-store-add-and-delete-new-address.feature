Feature: Log in, add new address and delete it

  Scenario Outline: Log in, add new address and delete it

    Given User is created in to CodersLab shop, one address is created and User is logged out
    When User goes to Login Page
    When User fills Email "ebkbdkmzbfmyljlrhl@kiabws.online"
    And User fills Password "qwe123"
    And User clicks Sing in button
    Then User is logged in to CodersLab shop and is on Your account site
    When User clicks Addresses button
    Then User goes to Your addresses page
    And There is one address made
    When User clicks Create new address button
    And User fills Alias "<alias>" in form
    And User fills Address "<address>" in form
    And User fills City "<city>" in form
    And User fills Zip "<zip>" in form
    And User chooses Country from list
    And User fills Phone "<phone>" in form
    And User clicks Save button in form
    Then User sees "Address successfully added" on page
    And Data is correct in new address
    When User clicks Delete button in new address
    Then User sees "Address successfully deleted!" on page
    And There is only one previous made address on page
    Examples:
      |alias   |address    |city   |zip   |phone    |
      |alias 1 |Kopernika 2|Gliwice|44-100|999999999|
      |alias 2 |Centaura 7 |Gliwice|44-117|111111111|