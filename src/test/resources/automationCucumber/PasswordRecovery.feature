Feature: Password Recovery

  Scenario Outline: Recover password for existing user
    Given I am on the Account page for password recovery
    When I click the "Lost your password?" link
    And I enter "<username>" into "Username or email" field
    And I click the "RESET PASSWORD" button to have my password reset
    Then I should see a confirmation message

    Examples: Valid Password Recovery

      | username               |

      # This username should exist in the system
      | testtest               |

      # This email should exist in the system
      | fri@me.com            |

