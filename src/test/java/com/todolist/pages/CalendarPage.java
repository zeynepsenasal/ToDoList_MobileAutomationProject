package com.todolist.pages;

import com.todolist.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarPage {
    public CalendarPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(xpath = "//*[@text='Time']")
    public RemoteWebElement timeButton;
    @AndroidFindBy(xpath="//*[@text='DONE']")
    public RemoteWebElement doneButton;
    @AndroidFindBy(xpath = "//*[@text='Reminder']")
    public RemoteWebElement reminderButton;

    @AndroidFindBy(className = "android.widget.Switch")
    public RemoteWebElement switchReminder;

    @AndroidFindBy(id="todolist.scheduleplanner.dailyplanner.todo.reminders:id/a2k")
    public RemoteWebElement setReminder;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[5]/android.widget.LinearLayout/android.widget.CheckBox")
    public RemoteWebElement thirtyMinuteReminder;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> dateOptions;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> timeOptions;

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
}
