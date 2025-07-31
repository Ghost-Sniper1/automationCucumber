Feature: Login and Add Product to Cart from the home page

  Scenario Outline: Login and add product to cart
    Given I am on the Account page
    When I enter "<username_or_email>" into the "Username or email address" field
    And I enter "<password>" into the "Password" field
    And I click the "LOG IN" button
    And I navigate on the home page
    Then I should add the product "<product_name>" to the cart

    Examples: Valid Login and Add Product
      | username_or_email | password     | product_name    |
#      | testtest          | 22           | Anchor Bracelet |
      | testtest@me.com   | 22           | Anchor Bracelet |