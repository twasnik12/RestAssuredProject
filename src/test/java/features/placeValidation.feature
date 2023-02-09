
Feature: validating place API's
 
  Scenario: verify is place is succsfully added with addplace API
    Given add place payload
    When user hits "AddPlaceAPI" with post request
    Then response get succesfull with status code is 200
    And "status" should be "OK"
 		And "scope" should be "APP"
 