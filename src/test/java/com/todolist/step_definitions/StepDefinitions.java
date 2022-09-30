package com.todolist.step_definitions;

import com.todolist.pages.BasePage;
import static com.todolist.utilities.Utils.*;

import com.todolist.utilities.ConfigurationReader;
import com.todolist.utilities.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class StepDefinitions extends BasePage {

    TouchAction touchAction = new TouchAction<>((PerformsTouchActions) Driver.getDriver());

    String taskName= ConfigurationReader.getProperty("task");

    String subtask = ConfigurationReader.getProperty("subtask");
    @Given("user enters to the application and closes the ads and lands on to the home page")
    public void user_enters_to_the_application() {
        sleep(1);
        if(continueButton2.isEnabled()){continueButton2.click();}else{continueButton.click();}
        sleep(1);
        closeAd.click();
        sleep(1);
        try{
            if(closeSecondAd.isDisplayed()){
                closeSecondAd.click();}
        }catch (Exception e){
            e.getMessage();
        }
    }

    @When("user clicks on the plus button")
    public void user_clicks_on_the_plus_button() {
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(plusButton))).perform();
    }
    @Then("user should see the task creation tab on screen")
    public void user_should_see_the_task_creation_tab_on_screen() {
        sleep(2);
       assertTrue(creationTab.isEnabled());
    }
    @Then("the buttons in the the task creation tab should be visible and clickable")
    public void the_buttons_in_the_the_task_creation_tab_should_be_visible_and_clickable() {
        assertTrue(name_inputBox.isEnabled());
        assertTrue(calenderButton.isEnabled());
        assertTrue(templatesButton.isEnabled());
        assertTrue(calenderButton.isEnabled());
    }

    @When("user enters a String to the input box")
    public void user_enters_a_string_to_the_input_box() {
        name_inputBox.click();
        name_inputBox.sendKeys(taskName);
    }

    @When("user clicks to the submit button")
    public void clicks_to_the_submit_button() {
        submitButton.click();
      sleep(3);
    }


    @Then("the user should see the created task on the home page successfully")
    public void the_user_should_see_the_created_task_on_the_homepage_successfully() {
        assertTrue(nameDisplayedInHomePage.isDisplayed());
        assertTrue(nameDisplayedInHomePage.getText().equals(taskName));
    }


    @And("user clicks on the category button")
    public void userClicksOnTheCategoryButton() {
        categoriesButton.click();
        sleep(2);
    }

    @And("user chooses a type of {string} on the tab")
    public void userChoosesATypeOfOnTheTab(String category) {
        selectCategory(category);
        sleep(2);
    }

    @And("user clicks on the calendar button")
    public void userClicksOnTheCalendarButton() {
        calenderButton.click();
        sleep(1);
    }

    @And("user chooses {string} as date from short options")
    public void userChoosesAsDateFromShortOptions(String dateOption) {
        selectDateOption(dateOption);
        sleep(1);
    }

    @And("user clicks on the Time button")
    public void userClicksOnTheTimeButton() {
        timeButton.click();
    }

    @And("user chooses {string} as time")
    public void userChoosesAsTime(String time) {
        selectTime(time);
    }

    @And("user clicks on the done button respectively")
    public void userClicksOnTheDoneButtonRespectively() {
        sleep(1);
        doneButton.click();
        sleep(1);
        doneButton.click();
    }

    @And("user clicks on the templates button")
    public void userClicksOnTheTemplatesButton() {
        templatesButton.click();
    }

    @And("user clicks on the add button for {string} template")
    public void userClicksOnTheAddButtonForTemplate(String templateName) {
        selectTemplate(templateName);
    }

    @And("user clicks on the Add to my list button")
    public void userClicksOnTheButton() {
        sleep(1);
        addToListButton.click();
    }
    @And("user passes the user tips coming for the first task")
    public void userPassesTheUserTipsComingForTheFirstTask() {
        sleep(1);
        nextButton.click();
        nextButton2.click();
        okButton.click();
    }
    @Then("the user should see the {string} task on the home page successfully")
    public void theUserShouldSeeTheTaskOnTheHomePageSuccessfully(String templateName) {
        assertTrue(nameDisplayedInHomePage.getText().equalsIgnoreCase(templateName));
    }

    @And("user clicks on the done button")
    public void userClicksOnTheDoneButton() {
        doneButton.click();
    }

    @And("user clicks the reminder button")
    public void userClicksTheReminderButton() {
        reminderButton.click();
    }

    @Then("user should see the reminder tab on the screen")
    public void userShouldSeeTheReminderTabOnTheScreen() {
        assertTrue(switchReminder.isEnabled());
    }

    @And("user selects a reminder time")
    public void userSelects_reminder_time() {
       setReminder.click();
       thirtyMinuteReminder.click();
       try{
           touchAction.tap(PointOption.point(323,853)).perform();
       }catch (Exception e){
           e.getMessage();
       }
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.elementToBeClickable(doneButton));
    }

    @And("user closes the window appeared for reminder setting")
    public void userChoosesTheSettingOfReminderFromTheWindowAppeared() {
        closeWindow.click();
    }
    @And("user clicks on the subtask button")
    public void userClicksOnTheSubtaskButton() {
        sleep(1);
        subTaskButton.click();
    }


    @And("user enters subtask name to the subtask input box")
    public void userEntersSubtaskNameToTheSubtaskInputBox() {
        sleep(1);
        subTaskInputBox.sendKeys(subtask);
    }

    @Then("the user should see the subtask in the task section")
    public void theUserShouldSeeTheSubtaskInTheTaskSection() {
        nameDisplayedInHomePage.click();
        sleep(1);
       assertTrue(displayedSubtaskName.getText().equals(subtask));
    }



}
