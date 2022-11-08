Feature: Serenity Test

Scenario: Test Scenario

  Given I navigate to HomePage
  When I type first name as 'Christian' and last name as 'Pulisic'
  And I select 'Europe' from Continents Dropdown
  And I upload a image
  And I verify the automation checkbox is unchecked
  And I hover over Selenium tab using Actions
