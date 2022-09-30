package com.todolist.pages;

import com.todolist.utilities.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    public RemoteWebElement continueButton;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/ajr")
    public RemoteWebElement continueButton2;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/acz")
    public RemoteWebElement closeAd;

    @AndroidFindBy(id = "todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public RemoteWebElement closeSecondAd;

    @AndroidFindBy(id="us")
    public RemoteWebElement plusButton;

    @AndroidFindBy(id="a_c")
    public RemoteWebElement name_inputBox;

    @AndroidFindBy(id= "a_8")
    public RemoteWebElement submitButton;

    @AndroidFindBy(id="a_b")
    public RemoteWebElement categoriesButton;

    @AndroidFindBy(id= "a_9")
    public RemoteWebElement calenderButton;

    @AndroidFindBy(id= "aap")
    public RemoteWebElement templatesButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public RemoteWebElement nextButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public RemoteWebElement nextButton2;


    @AndroidFindBy(xpath= "//*[@text='OK']")
    public RemoteWebElement okButton;

    @AndroidFindBy(id="a_e")
    public RemoteWebElement creationTab;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/aal")
    public RemoteWebElement nameDisplayedInHomePage;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout")
    public List<RemoteWebElement> listOfTemplates;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/e6")
    public RemoteWebElement controlPanel;

    public void selectTemplate(int i){
        listOfTemplates.get(i).click();
    }

    @AndroidFindBy(xpath = "//*[@text='Time']")
    public RemoteWebElement timeButton;
    @AndroidFindBy(xpath="//*[@text='DONE']")
    public RemoteWebElement doneButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")
    public List<RemoteWebElement> categories;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a_d")
    public RemoteWebElement subTaskButton;

    @AndroidFindBy(xpath = "//*[@text='Input the sub-task']")
    public RemoteWebElement subTaskInputBox;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a82")
    public RemoteWebElement displayedSubtaskName;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> dateOptions;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> timeOptions;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> templateOptions;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/aaq")
    public RemoteWebElement addToListButton;

    @AndroidFindBy(xpath = "//*[@text='Reminder']")
    public RemoteWebElement reminderButton;

    @AndroidFindBy(className = "android.widget.Switch")
    public RemoteWebElement switchReminder;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/a2k")
    public RemoteWebElement setReminder;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[5]/android.widget.LinearLayout/android.widget.CheckBox")
    public RemoteWebElement thirtyMinuteReminder;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/re")
    public RemoteWebElement reminderSetting_floatingWindow;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public RemoteWebElement closeWindow;

    public void selectCategory(String category){
        for (RemoteWebElement option : categories) {
            if(option.getText().equalsIgnoreCase(category)){
                option.click();
            }
        }
    }
    public void selectDateOption(String dateOption){
        for (RemoteWebElement option : dateOptions) {
            if(option.getText().equalsIgnoreCase(dateOption)){
                option.click();
                break;
            }
        }
    }
    public void selectTime(String timeOption){
        for (RemoteWebElement option : timeOptions) {
            if(option.getText().equalsIgnoreCase(timeOption)){
                option.click();
                break;
            }
        }
    }

    public void selectTemplate(String template){
        for (RemoteWebElement templateOption : templateOptions) {
            if(templateOption.getText().equalsIgnoreCase(template)){
                templateOption.click();
                break;
            }
        }
    }
}
