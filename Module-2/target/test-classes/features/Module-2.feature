Feature: Module-2 feature

  Scenario: Search, Add and verify whether product is add in cart
    Given User opens the Amazon Home Page
    When user searches 'Nike' in the Search Text Box
    And I navigate to the 'Search Results' Page
    And I click on the first result of the searched item
    And I navigate to the 'Product' Page
    And I select index 2 from the size dropdown
    And I click on Add to Cart button
    And I navigate to the 'Cart' Page
    Then I verify the item is added to the cart successfully