Feature: User Registration

  Scenario Outline: Register with valid inputs
    Given I am on the account page
    When I enter "<username>" into the "username" field
    And I enter "<email>" into the "Email address" field
    And I enter "<password>" into the "Password" field
    And I click the "REGISTER" button
    Then I should be redirected to my personal dashboard

    Examples: Valid Registration
      | username   | email           | password       |
      | loveuj       | uyrer@me.com     |   1            |