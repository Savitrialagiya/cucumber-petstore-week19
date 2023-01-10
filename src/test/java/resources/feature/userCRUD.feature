Feature: Pet store io user functionality
  As a user I want to test pet store functionality

  Scenario Outline: Crud Test
    When I create user with id "<id>" username "<username>" firstname"<firstname>" lastname"<lastname>" email"<email>" password"<password>" phone"<phone>" userstatus"<userstatus>"
    And I verify user created
    And I update user with id "<id>" username "<username>" firstname"<firstname>" lastname"<lastname>" email"<email>" password"<password>" phone"<phone>" userstatus"<userstatus>"
    And I check user is updated successfully
    And I delete user
    Then I verify that user is deleted successfully
    Examples:
      | id | username | firstname | lastname | email            | password | phone     | userstatus |
      | 1  | abcde    | abc       | xyz      | abc123@gmail.com | abc123   | 123456789 | 0     |
