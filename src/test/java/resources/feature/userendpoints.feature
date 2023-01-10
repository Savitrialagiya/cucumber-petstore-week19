Feature: Testing different request on the petstore application

  Scenario: verify if user is created
    When I create new user by providing the information
    Then I must get a valid status code 201

  Scenario: Check if the petstore application can be accessed by User
    When I sends a GET request to userID endpoint
    Then I must get back a valid status code 200

  Scenario: verify if user is updated
    When I update new user by providing the information
    Then I must get back a valid status code 200

  Scenario: verify if user is Deleted
    When I delete a DELETE request by providing information
    Then I verify that the status code