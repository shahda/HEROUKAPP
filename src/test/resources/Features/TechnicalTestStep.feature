@RunAllScenarios
Feature: HEROKUAPP

  @getUsersbyCity
  Scenario Outline: Get Users by City
    When the request is performed using city "<city>"
    Then response should be 200
    And verify that the response includes the data for "<city>"

    Examples:
      | city    |
      | London   |
      | Leeds   |

  @getInstruction
  Scenario: Get Instructions
     When the request is performed using instructions
     Then response should be 200
     And the response includes the correct message

  @getUserById
  Scenario Outline: Get user by ID
    When the request is performed using user id "<id>"
    Then response should be 200
    And the response includes the correct id "<id>"
    Examples:
      | id    |
      |1000|
      |800|
      |500|

  @getAllUsers
  Scenario: Get all users
    When the request is performed to get all users
    Then response should be 200
    And the response does not include null id field