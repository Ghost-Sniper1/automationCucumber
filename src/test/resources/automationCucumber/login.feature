Feature: Login functionality

  Scenario Outline: Successful login with valid credentials
    Given I am on the Account page
    When I enter "<username_or_email>" into the "Username or email address" field
    And I enter "<password>" into the "Password" field
    And I click the "LOG IN" button
    Then I should be redirected to the "My account" page as an authenticated user

    Examples: Valid Login
      | username_or_email     | password       |
      | validuser@example.com | ValidPass123!  |