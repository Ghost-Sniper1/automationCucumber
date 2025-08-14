Feature: Add to Cart

  @A1
  Scenario Outline: Add one quantity to the cart
    Given I'm on the Store page
    When I add a "<productName>" to the cart
    Then I should see 1 "<productName>" in the cart

    Examples:
      | productName |
      | Blue Shoes  |