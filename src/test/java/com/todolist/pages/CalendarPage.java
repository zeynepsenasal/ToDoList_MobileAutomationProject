package com.todolist.pages;

import com.todolist.utilities.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarPage {
    public CalendarPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @FindBy(xpath = "//*[@text='Time']")
    public MobileElement timeButton;
    @AndroidFindBy(xpath="//*[@text='DONE']")
    public MobileElement doneButton;
    @AndroidFindBy(xpath = "//*[@text='Reminder']")
    public MobileElement reminderButton;

    @AndroidFindBy(className = "android.widget.Switch")
    public MobileElement switchReminder;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/a2k")
    public MobileElement setReminder;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[5]/android.widget.LinearLayout/android.widget.CheckBox")
    public MobileElement thirtyMinuteReminder;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    public List<MobileElement> dateOptions;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public List<MobileElement> timeOptions;

    public void selectDateOption(String dateOption){
        for (MobileElement option : dateOptions) {
            if(option.getText().equalsIgnoreCase(dateOption)){
                option.click();
                break;
            }
        }
    }
    public void selectTime(String timeOption){
        for (MobileElement option : timeOptions) {
            if(option.getText().equalsIgnoreCase(timeOption)){
                option.click();
                break;
            }
        }
    }
}
