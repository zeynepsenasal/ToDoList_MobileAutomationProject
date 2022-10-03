package com.todolist.pages;

import com.todolist.utilities.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }
    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    public MobileElement continueButton;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/ajr")
    public MobileElement continueButton2;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/acz")
    public MobileElement closeAd;

    @AndroidFindBy(id = "todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public MobileElement closeSecondAd;

    @AndroidFindBy(id="us")
    public MobileElement plusButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public MobileElement nextButton;

    @AndroidFindBy(xpath= "//*[@text='Next']")
    public MobileElement nextButton2;


    @AndroidFindBy(xpath= "//*[@text='OK']")
    public MobileElement okButton;


    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/aal")
    public MobileElement nameDisplayedInHomePage;
    @AndroidFindBy(id="a_c")
    public MobileElement name_inputBox;

    @AndroidFindBy(id= "a_8")
    public MobileElement submitButton;

    @AndroidFindBy(id="a_b")
    public MobileElement categoriesButton;

    @AndroidFindBy(id= "a_9")
    public MobileElement calenderButton;

    @AndroidFindBy(id= "aap")
    public MobileElement templatesButton;


    @AndroidFindBy(id="a_e")
    public MobileElement creationTab;


    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")
    public List<MobileElement> categories;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a_d")
    public MobileElement subTaskButton;

    @AndroidFindBy(xpath = "//*[@text='Input the sub-task']")
    public MobileElement subTaskInputBox;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/a82")
    public MobileElement displayedSubtaskName;


    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/j_")
    public MobileElement closeWindow;

    public void selectCategory(String category){
        for (MobileElement option : categories) {
            if(option.getText().equalsIgnoreCase(category)){
                option.click();
            }
        }
    }




}
