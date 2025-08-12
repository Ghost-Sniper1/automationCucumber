Feature: User Registration

  Scenario Outline: Register with valid inputs
    Given I am on the account page
    When I enter "<username>" into the "username" field
    And I enter "<email>" into the "Email address" field
    And I enter "<password>" into the "Password" field
    And I click the "REGISTER" button
    Then I should be redirected to my personal dashboard

    Examples: Valid Registration

    # Before running this test case, the username and email should unique and not already registered(new data).
    # The existing one are already registered in the database.
      | username   | email           | password       |
      | gru        | grut@me.com      | 343            |

  Scenario Outline: Register with invalid or duplicate inputs
    Given I am on the account page
    When I enter "<username>" into the "username" field
    And I enter "<email>" into the "Email address" field
    And I enter "<password>" into the "password" field
    And I click the "REGISTER" button
    Then I should see the registration error message "<expectedError>"

    Examples: Invalid Registration
      | username          | email             | password | expectedError                                                                      |
      | sun               | sun@me.com        | 343      | Error: An account is already registered with your email address. Please log in.    |
      | thinkpad          | sun@me.com        | 123456   | Error: An account is already registered with your email address. Please log in.    |
      | thinkpad          | thinkpad@me.com   |          | Error: Please enter an account password.                                           |
      |                   | thinkpad@me.com   | 123456   | Error: Please enter a valid account username.                                      |
      | thinkpad          |                   | 123456   | Error: Please provide a valid email address.                                       |
      |                   |                   |          | Error: Please provide a valid email address.                                       |

