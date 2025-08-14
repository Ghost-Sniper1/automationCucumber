Feature: Manage Cart

  @A9
  Scenario Outline: Update quantity in the cart
    Given I'm on the Store page
    And I add a "<productName>" to the cart
    When I update the quantity of "<productName>" in the cart to <newQuantity>
    Then I should see <newQuantity> "<productName>" in the cart

    Examples:
    | productName | newQuantity |
    | Blue Shoes  | 3           |