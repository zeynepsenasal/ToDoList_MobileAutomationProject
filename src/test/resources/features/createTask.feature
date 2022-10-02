@US01
Feature: User should be able to create task by the plus button

  Background: User is expected to be on the home page
    Given user enters to the application and closes the ads and lands on to the home page

  @TC01
  Scenario: Verify that the user can open the task creation tab by clicking the plus button
    When user clicks on the plus button
    Then user should see the task creation tab on screen
    Then the buttons in the the task creation tab should be visible and clickable

  @TC02
  Scenario: Verify that the user can successfully create a basic task in task creation tab
    When user clicks on the plus button
    And user enters a String to the input box
    And user clicks to the submit button
    And user passes the user tips coming for the first task
    Then the user should see the created task on the home page successfully

  @TC03
  Scenario: Verify that the user cannot create an empty task
    When user clicks on the plus button
    And user clicks to the submit button
    Then the user should see "" message on screen

  @TC04
  Scenario Outline: Verify that the user can choose type of category for the task
    When user clicks on the plus button
    And user enters a String to the input box
    And user clicks on the category button
    And user chooses a type of "<Category>" on the tab
    And user clicks to the submit button
    And user passes the user tips coming for the first task
    Then the user should see the created task on the home page successfully
    Examples:
      | Category |
      | Work     |
      | Personal |
      | Wishlist |
      | Birthday |


  @TC05
  Scenario Outline: Verify that the user can successfully set a date for the task
    When user clicks on the plus button
    And user enters a String to the input box
    And user clicks on the calendar button
    And user chooses "<Date>" as date from short options
    And user clicks on the done button
    And user clicks to the submit button
    And user passes the user tips coming for the first task
    Then the user should see the created task on the home page successfully
    Examples:
      | Date         |
      | Tomorrow     |
      | 3 Days Later |
      | This Sunday  |

  @TC06
  Scenario: Verify that the user can successfully set time and reminder for the task
    When user clicks on the plus button
    And user enters a String to the input box
    And user clicks on the calendar button
    And user clicks on the Time button
    And user chooses "10:00 AM" as time
    And user clicks on the done button
    And user clicks the reminder button
    Then user should see the reminder tab on the screen
    And user selects a reminder time
    And user clicks on the done button respectively
    And user clicks to the submit button
    And user passes the user tips coming for the first task
    And user closes the window appeared for reminder setting
    Then the user should see the created task on the home page successfully

  @TC07
  Scenario: Verify that the user can successfully create a task by using a template
    When user clicks on the plus button
    And user clicks on the templates button
    And user clicks on the add button for "Go Exercising" template
    And user clicks on the Add to my list button
    And user passes the user tips coming for the first task
    Then the user should see the "Go Exercising" task on the home page successfully

  @TC08
  Scenario: Verify that the user can successfully create subtasks under the task
    When user clicks on the plus button
    And user enters a String to the input box
    And user clicks on the subtask button
    And user enters subtask name to the subtask input box
    And user clicks to the submit button
    And user passes the user tips coming for the first task
    Then the user should see the subtask in the task section
