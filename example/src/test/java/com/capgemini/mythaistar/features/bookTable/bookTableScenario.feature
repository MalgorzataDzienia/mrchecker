@Test
Feature: My Thai Star book table

  Background:
    Given I am on the book table page
    And I click on Date and time field

  Scenario Outline: Test book table page with different data
    And I set date <date> and <hour> hour and <minutes> minutes
    When I complete action
    And I set name field with <name> value
    And I set email field with <email> value
    And I set table guests field with <guests> value
    And I checked accept terms checkbox
    When I click book table button
    Then The status of reservation should be <status>

    Examples:
      | date    | hour    | minutes | email                | guests  | status  |
      | current | valid   | valid   | mythaitest@gmail.com | valid   | success |
      | future  | valid   | valid   | mythaitest@gmail.com | valid   | success |
      | current | invalid | valid   | mythaitest@gmail.com | valid   | failed  |
      | current | valid   | invalid | mythaitest@gmail.com | valid   | success |
      | current | valid   | valid   | mythaitest@gmail.com | invalid | failed  |
      | current | valid   | valid   | mythaitest@gmail.com | double  | success |
      | current | valid   | valid   | mythaitest@gmail.com | valid   | success |

  @tag
  Scenario: Test book a table form with empty name
    And I set current date and set valid time
    When I complete action
    And I set email field with 'mythaitest@gmail.com' value
    And I set table guests field with '5' value
    When I checked accept terms checkbox
    Then I can not click book table button
    But Name field should be displayed as required

  Scenario: Test book a table with invalid email
    And I set actual date and time
    When I complete action
    And I set name field with 'NewUser' value
    And I set email field with 'test@' value
    And I checked accept terms checkbox
    When Book table button should be invisible
    Then Email field should be valid

  Scenario: Test book a table with unchecked Accept terms
    And I set current date and time
    When I complete action
    And I set name field with 'NewUser' value
    And I set email field with 'mythaitest@gmail.com' value
    And I set table guests field with '5' value
    Then Book table button should be invisible

 