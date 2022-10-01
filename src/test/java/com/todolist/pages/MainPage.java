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

public class MainPage {
    public MainPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    public MobileElement continueButton;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/ajr")
    public RemoteWebElement continueButton2;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/acz")
    public RemoteWebElement closeAd;

    @AndroidFindBy(id = "todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public RemoteWebElement closeSecondAd;

    @AndroidFindBy(id="us")
    public RemoteWebElement plusButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public RemoteWebElement nextButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public RemoteWebElement nextButton2;


    @AndroidFindBy(xpath= "//*[@text='OK']")
    public RemoteWebElement okButton;


    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/aal")
    public RemoteWebElement nameDisplayedInHomePage;
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


    @AndroidFindBy(id="a_e")
    public RemoteWebElement creationTab;


    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")
    public List<RemoteWebElement> categories;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a_d")
    public RemoteWebElement subTaskButton;

    @AndroidFindBy(xpath = "//*[@text='Input the sub-task']")
    public RemoteWebElement subTaskInputBox;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a82")
    public RemoteWebElement displayedSubtaskName;


    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public RemoteWebElement closeWindow;

    public void selectCategory(String category){
        for (RemoteWebElement option : categories) {
            if(option.getText().equalsIgnoreCase(category)){
                option.click();
            }
        }
    }




}
