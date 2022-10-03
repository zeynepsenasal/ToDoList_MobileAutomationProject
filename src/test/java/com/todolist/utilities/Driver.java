package com.todolist.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static InheritableThreadLocal<AppiumDriver> driverPool = new InheritableThreadLocal<>();
    private static URL  url;

    static {
        try {
            url = new URL(ConfigurationReader.getProperty("url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver<MobileElement> getDriver(){
        if(driverPool.get()==null){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.getProperty("platform_name"));
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, ConfigurationReader.getProperty("android_version"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.getProperty("device_name"));
            desiredCapabilities.setCapability("appium:appPackage", ConfigurationReader.getProperty("app_package"));
            desiredCapabilities.setCapability("appium:appActivity", ConfigurationReader.getProperty("app_activity"));
            desiredCapabilities.setCapability("appium:enableMultiWindows",true);

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
