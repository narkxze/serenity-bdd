@m3
Feature: Pet Store

  Background:
    Given I setup baseURL and preconditions

  Scenario: POST-Request For PET STORE
    Given I prepare POST request body with the following parameters
      | id | category-id | category-name | name   | photoUrls | tags-id | tags-name | status    |
      | 0  | 0           | string        | doggie | string    | 0       | string    | available |
    When I send POST request for 'pet' endpoint
    Then I save the ID from response for further usage
    And I validate the JSON SCHEMA for the generated ID compared to 'GETPetsSchema.json'

  Scenario: DELETE-Request for PET STORE
    When I delete the records for the previously created ID
    And I run GET request for the same ID after deletion
    Then I verify the status code is 404 and message 'Pet not found'


