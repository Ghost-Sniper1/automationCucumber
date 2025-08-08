Feature: Login functionality

  Scenario Outline: Successful login with valid credentials
    Given I am on the Account page for login
    When I enter "<username_or_email>" into the "Username or email address" field for login
    And I enter "<password>" into the "Password" field for login
    And I click the "LOG IN" button for regular login
    Then I should be redirected to the "My account" page as an authenticated user

    Examples: Valid Login
      | username_or_email     | password   |
      | test54@test.com       | 1          |