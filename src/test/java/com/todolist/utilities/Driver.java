package com.todolist.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static InheritableThreadLocal<AppiumDriver<MobileElement>> driverPool = new InheritableThreadLocal<>();
    private static URL  url;

    static {
        try {
            url = new URL(ConfigurationReader.getProperty("url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AppiumDriver<MobileElement> getDriver(){
        if(driverPool.get()==null){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.getProperty("device_name"));
            desiredCapabilities.setCapability("appPackage", ConfigurationReader.getProperty("app_package"));
            desiredCapabilities.setCapability("appActivity", ConfigurationReader.getProperty("app_activity"));
            desiredCapabilities.setCapability("enableMultiWindows",true);

            driverPool.set(new AndroidDriver<MobileElement>(url,desiredCapabilities));

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
}

}
