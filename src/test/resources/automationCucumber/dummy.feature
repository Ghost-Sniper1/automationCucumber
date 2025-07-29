@dummyFeatures
Feature: Add to Cart

  Rule: Add from the store

  Scenario Outline: Add one quantity to the cart

    Given I'm on the Store page
    When I add a "<product_name>"  to the cart
    Then I see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blues Shoes  |


