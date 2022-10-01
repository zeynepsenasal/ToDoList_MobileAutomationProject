package com.todolist.pages;

import com.todolist.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TemplatePage {
    public TemplatePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    public List<RemoteWebElement> templateOptions;

    @AndroidFindBy(id= "todolist.scheduleplanner.dailyplanner.todo.reminders:id/aaq")
    public RemoteWebElement addToListButton;

    public void selectTemplate(String template){
        for (RemoteWebElement templateOption : templateOptions) {
            if(templateOption.getText().equalsIgnoreCase(template)){
                templateOption.click();
                break;
            }
        }
    }
}
