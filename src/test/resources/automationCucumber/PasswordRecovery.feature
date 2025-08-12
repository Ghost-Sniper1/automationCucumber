Feature: Password Recovery

  Scenario Outline: Recover password for existing user
    Given I am on the Account page for password recovery
    When I click the "Lost your password?" link
    And I enter "<username>" into "Username or email" field
    And I click the "RESET PASSWORD" button to have my password reset
    Then I should see a confirmation message

    # The username or email must exist in the system
    Examples: Valid Password Recovery
      | username                |
      | testtest                |
      | fri@me.com              |


  Scenario Outline: Recover password with invalid or empty input
    Given I am on the Account page for password recovery
    When I click the "Lost your password?" link
    And I enter "<username>" into "Username or email" field
    And I click the "RESET PASSWORD" button to have my password reset
    Then I should see the error message "<expectedError>"

    Examples: Invalid Password Recovery
      | username           | expectedError                       |
      | risk               | Invalid username or email.          |
      | risk@me.de         | Invalid username or email.          |
      |                    | Enter a username or email address.  |


