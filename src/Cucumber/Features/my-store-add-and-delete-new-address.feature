Feature: Log in, add new address and delete it

  Scenario Outline: Log in, add new address and delete it

    Given User is created in to CodersLab shop, one address is created and User is logged out
    When User goes to Login Page
    When User logs with Email "ebkbdkmzbfmyljlrhl@kiabws.online" and Password "qwe123"
    Then User clicks Addresses button and goes to Your addresses page
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
      | alias   | address     | city    | zip    | phone     |
      | alias 1 | Kopernika 2 | Gliwice | 44-100 | 999999999 |
      | alias 2 | Centaura 7  | Gliwice | 44-117 | 111111111 |