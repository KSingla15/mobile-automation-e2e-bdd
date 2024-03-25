@AddItemsToCart
Feature: Add items to cart
  As a customer,
  I want to add items to cart
  So that I can checkout and continue shopping

  Scenario Outline: Add <Item name> in <Color> to cart
    Given I am on the homepage
    And I navigate to the catalog
    And I select "<Item name>"
    And I choose color as "<Color>" of the item
    And I add "<Items count>" to the cart
    When I navigate to the cart
    Then the total number of items in the cart should be "<Items count>"
    Examples:
      | Item name           |Color |Items count|
      | Sauce Labs Backpack |blue  | 2 items   |
      | Sauce Labs Backpack |black | 2 items   |