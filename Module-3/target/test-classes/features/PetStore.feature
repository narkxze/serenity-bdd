@m3
Feature: PetStore API Scenarios

  Background:
    Given I setup the baseURL and preconditions

  @tc1
  Scenario: Verify status code is 200 of FindByStatus
    Then I verify the status code of 'findByStatus' endpoint is 200

  @tc2
  Scenario: Verify all the status of the pets are available in the response
    When I fetch the records of pets that are of 'available' status
    Then I verify the count of pets are more than 5
    And I log the number of pets that has been found in the response

  @tc3
  Scenario: Verify the Response Headers
    When I run GET request for 'findByStatus' endpoint
    Then I verify the following response headers
      | Content-Type     | Access-Control-Allow-Methods |
      | application/json | GET, POST, DELETE, PUT       |

  @tc4
  Scenario: Verify status code is 404 of FindByStatus
    Then I verify the status code of 'findByStatus' endpoint is 200
