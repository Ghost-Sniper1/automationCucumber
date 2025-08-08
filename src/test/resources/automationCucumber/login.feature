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

  Scenario Outline: Unsuccessful login with invalid credentials or empty fields
    Given I am on the Account page for login
    When I enter "<username_or_email>" into the "Username or email address" field for login
    And I enter "<password>" into the "Password" field for login
    And I click the "LOG IN" button for regular login
    Then I should see an error message "<errorMessage>"

    Examples: Invalid Credentials
      | username_or_email     | password     | errorMessage |
      | wronguser@test.com    | 1            |  Unknown email address. Check again or try your username.            |
      | test54@test.com       | wrongpass    |  Error: The password you entered for the email address test54@test.com is incorrect. Lost your password? |
      |                       |              |  Error: Username is required.                                                                                                                                                                                      |

