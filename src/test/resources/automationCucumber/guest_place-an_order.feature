Feature: Place an order

  @A2
  Scenario Outline: using default payment option
    Given I'm a guest customer
    And I have a "<productName>" in the cart
    And I'm on the checkout page
    Then I provide billing details
      | firstname | lastname | country           | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States(US) | 6300 Spring Creek | Plano | Texas | 75024 | asked@gmail.com    |

    And I place an order
    Then The order should be placed successfully

    Examples:
      | productName |
      | Blue Shoes  |