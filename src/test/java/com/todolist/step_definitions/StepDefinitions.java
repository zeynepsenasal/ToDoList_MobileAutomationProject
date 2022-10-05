package com.todolist.step_definitions;

import static com.todolist.utilities.Utils.*;

import com.todolist.pages.CalendarPage;
import com.todolist.pages.MainPage;
import com.todolist.pages.TemplatePage;
import com.todolist.utilities.ConfigurationReader;
import com.todolist.utilities.Driver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class StepDefinitions {

    MainPage mainPage= new MainPage();
    CalendarPage calendarPage=new CalendarPage();
    TemplatePage templatePage= new TemplatePage();
    TouchAction touchAction = new TouchAction<>((PerformsTouchActions) Driver.getDriver());
    String taskName= ConfigurationReader.getProperty("task");
    String subtask = ConfigurationReader.getProperty("subtask");


    @Given("user enters to the application and closes the ads and lands on to the home page")
    public void user_enters_to_the_application() {
        sleep(1);
        if(mainPage.continueButton2.isEnabled()){mainPage.continueButton2.click();}else{mainPage.continueButton.click();}
        sleep(1);
        mainPage.closeAd.click();
        sleep(1);
        try{
            if(mainPage.closeSecondAd.isDisplayed()){
                mainPage.closeSecondAd.click();}
        }catch (Exception e){
            e.getMessage();
        }
    }

    @When("user clicks on the plus button")
    public void user_clicks_on_the_plus_button() {
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.plusButton))).perform();
    }
    @Then("user should see the task creation tab on screen")
    public void user_should_see_the_task_creation_tab_on_screen() {
        sleep(2);
       assertTrue(mainPage.creationTab.isEnabled());
    }
    @Then("the buttons in the the task creation tab should be visible and clickable")
    public void the_buttons_in_the_the_task_creation_tab_should_be_visible_and_clickable() {
        assertTrue(mainPage.name_inputBox.isEnabled());
        assertTrue(mainPage.calenderButton.isEnabled());
        assertTrue(mainPage.templatesButton.isEnabled());
        assertTrue(mainPage.calenderButton.isEnabled());
    }

    @When("user enters a String to the input box")
    public void user_enters_a_string_to_the_input_box() {
        mainPage.name_inputBox.click();
        mainPage.name_inputBox.sendKeys(taskName);
    }

    @When("user clicks to the submit button")
    public void clicks_to_the_submit_button() {
        mainPage.submitButton.click();
    }


    @Then("the user should see the created task on the home page successfully")
    public void the_user_should_see_the_created_task_on_the_homepage_successfully() {
        assertTrue(mainPage.nameDisplayedInHomePage.isDisplayed());
        assertTrue(mainPage.nameDisplayedInHomePage.getText().equals(taskName));
    }

    @And("user enters blank space to the input box")
    public void userEntersBlankSpaceToTheInputBox() {
        mainPage.name_inputBox.sendKeys("  ");
    }

    @Then("the task should not be created")
    public void theTaskShouldNotBeCreated() {
        try{
            assertFalse(mainPage.nameDisplayedInHomePage.isDisplayed());
        }catch (Exception e){
            e.getMessage();
        }
    }

    @And("user clicks on the category button")
    public void userClicksOnTheCategoryButton() {
        mainPage.categoriesButton.click();
        sleep(2);
    }

    String selectetCategory="";

    @And("user chooses a type of {string} on the tab")
    public void userChoosesATypeOfOnTheTab(String category) {
        mainPage.selectCategory(category);
        selectetCategory=category;
        sleep(2);
    }

    @Then("user should see the selected category type by clicking on the created task")
    public void userShouldSeeTheSelectedCategoryTypeByClickingOnTheCreatedTask() {
        mainPage.nameDisplayedInHomePage.click();
        sleep(1);
        assertEquals(mainPage.categoryDisplayedInsideTask.getText(), selectetCategory);
    }

    @And("user clicks on the calendar button")
    public void userClicksOnTheCalendarButton() {
        mainPage.calenderButton.click();
        sleep(1);
    }

    @And("user chooses {string} as date from short options")
    public void userChoosesAsDateFromShortOptions(String dateOption) {
       calendarPage.selectDateOption(dateOption);
        sleep(1);
    }

    @And("user clicks on the Time button")
    public void userClicksOnTheTimeButton() {
        calendarPage.timeButton.click();
    }

    @And("user chooses {string} as time")
    public void userChoosesAsTime(String time) {
       calendarPage.selectTime(time);
    }

    @And("user clicks on the done button respectively")
    public void userClicksOnTheDoneButtonRespectively() {
        sleep(1);
        calendarPage.doneButton.click();
        sleep(1);
        calendarPage.doneButton.click();
    }

    @And("user clicks on the templates button")
    public void userClicksOnTheTemplatesButton() {
        mainPage.templatesButton.click();
    }

    @And("user clicks on the add button for {string} template")
    public void userClicksOnTheAddButtonForTemplate(String templateName) {
        templatePage.selectTemplate(templateName);
    }

    @And("user clicks on the Add to my list button")
    public void userClicksOnTheButton() {
        sleep(1);
        templatePage.addToListButton.click();
    }
    @And("user passes the user tips coming for the first task")
    public void userPassesTheUserTipsComingForTheFirstTask() {
        sleep(4);
        mainPage.nextButton.click();
        mainPage.nextButton2.click();
        mainPage.okButton.click();
    }
    @Then("the user should see the {string} task on the home page successfully")
    public void theUserShouldSeeTheTaskOnTheHomePageSuccessfully(String templateName) {
        assertTrue(mainPage.nameDisplayedInHomePage.getText().equalsIgnoreCase(templateName));
    }

    @And("user clicks on the done button")
    public void userClicksOnTheDoneButton() {
        calendarPage.doneButton.click();
    }

    @And("user clicks the reminder button")
    public void userClicksTheReminderButton() {
       calendarPage.reminderButton.click();
    }

    @Then("user should see the reminder tab on the screen")
    public void userShouldSeeTheReminderTabOnTheScreen() {
        assertTrue(calendarPage.switchReminder.isEnabled());
    }

    @And("user selects a reminder time")
    public void userSelects_reminder_time() {
      calendarPage.setReminder.click();
      calendarPage.thirtyMinuteReminder.click();
       try{
           touchAction.tap(PointOption.point(323,853)).perform();
       }catch (Exception e){
           e.getMessage();
       }
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.doneButton));
    }

    @And("user closes the window appeared for reminder setting")
    public void userChoosesTheSettingOfReminderFromTheWindowAppeared() {
        mainPage.closeWindow.click();
    }
    @And("user clicks on the subtask button")
    public void userClicksOnTheSubtaskButton() {
        sleep(1);
        mainPage.subTaskButton.click();
    }


    @And("user enters subtask name to the subtask input box")
    public void userEntersSubtaskNameToTheSubtaskInputBox() {
        sleep(1);
        mainPage.subTaskInputBox.sendKeys(subtask);
    }

    @Then("the user should see the subtask in the task section")
    public void theUserShouldSeeTheSubtaskInTheTaskSection() {
        mainPage.nameDisplayedInHomePage.click();
        sleep(1);
       assertTrue(mainPage.displayedSubtaskName.getText().equals(subtask));
    }



}
