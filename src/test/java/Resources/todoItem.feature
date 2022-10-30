Feature: Manage Todo Item List
  Scenario: User add single todo item
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"

  Scenario: User add single todo item and delete
    Given user navigate todos page
    When user add "Task 1" and hit enter
    And user delete "Task 1"
    Then user should not be able to see "Task 1"

  Scenario: User add multiple todo items
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"
    And user add "Task 2" and hit enter
    Then user should be able to see "Task 2"
    And user add "Task 3" and hit enter
    Then user should be able to see "Task 3"

  Scenario: User complete task and filter out completed item
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"
    And user add "Task 2" and hit enter
    Then user should be able to see "Task 2"
    And user add "Task 3" and hit enter
    Then user should be able to see "Task 3"
    When user complete "Task 2"
    And user click "completed" link button
    Then user should be able to see "Task 2"

  Scenario: User complete task and filter out active items
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"
    And user add "Task 2" and hit enter
    Then user should be able to see "Task 2"
    And user add "Task 3" and hit enter
    Then user should be able to see "Task 3"
    When user complete "Task 1"
    And user click "active" link button
    Then user should be able to see "Task 2"
    And user should be able to see "Task 3"

  Scenario: User clear completed tasks
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"
    And user add "Task 2" and hit enter
    Then user should be able to see "Task 2"
    And user add "Task 3" and hit enter
    Then user should be able to see "Task 3"
    When user complete "Task 2"
    When user click "Clear completed" button
    Then user should be able to see "Task 1"
    And user should be able to see "Task 3"

  Scenario: User clear completed tasks and filter all
    Given user navigate todos page
    When user add "Task 1" and hit enter
    Then user should be able to see "Task 1"
    And user add "Task 2" and hit enter
    Then user should be able to see "Task 2"
    And user add "Task 3" and hit enter
    Then user should be able to see "Task 3"
    When user complete "Task 3"
    And user click "completed" link button
    And user click "Clear completed" button
    And user click "all" link button
    Then user should be able to see "Task 1"
    And user should be able to see "Task 2"