## This framework has been created by Zeynep Sena Saltık for automation testing of the "To-Do List" mobile application.
### 1. The framework consists of automation test cases for "To-Do List" which is a mobile application where users can create a list of tasks and plans.This app has been chosen because it allows the users to create their interface.
### 2. The application is tested against a virtual device by using Android Studio, Appium Inspector and Appium Server GUI.
### 3. BDD approach implemented by using Cucumber, Java, Appium, and JUnit.
### 4. Test scenarios can be found in the feature file provided under the resources directory. There are 8 test scenarios in the feature file, focusing on the functionality of the "task creation" module.
### 5. Test cases are created according to the acceptance criteria for the main function (user story). Test scenarios are written in Gherkin language by using Given, When, Then annotations and some of the test cases are created as Scenario Outline to achieve Data Driven Testing (DDT) and tested against different test data.
### 6. Test scenarios are defined with codes in StepDefinition class and triggered by the CukesRunner class.
### 7. Page Object Model (POM) implemented with the "BasePage" class to centralize the locators of mobile elements and avoid hardcoding.
### 8. Singleton Design Pattern implemented in Driver class in order to use single driver object and avoid synchronization issues.
### 9. ConfigurationReader class is used to retrieve some test data from the configuration.properties file in order to be able to manage the test data from a central location.