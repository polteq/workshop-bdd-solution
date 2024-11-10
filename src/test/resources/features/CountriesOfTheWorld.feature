Feature: Test knowledge of the world
  As a user
  I want to fill in all the countries of the world
  So that I know my knowledge of the world is more than ok

  Scenario: Fill in all the countries of the world
    Given I am on the Countries of the World Quiz website
    When I start the quiz
    And I fill in all the countries of the world
    Then all the countries should appear in the list as correct
