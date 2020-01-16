package org.appiumseleniumpoc.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BagPage {

    AndroidDriver driver;
    WebDriverWait wait;

    /*@FindBy(xpath = ".//*[@resource-id='com.ae.ae:id/dont_have_account']")
    WebElement signin;*/


    public BagPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
    }

    @Step
    public void goToLogin(){
        driver.findElementByXPath(".//android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.ae.ae:id/dont_have_account']").isDisplayed();
        WebElement gotosignin=driver.findElementByXPath(".//android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.ae.ae:id/dont_have_account']");
        Actions actions= new Actions(driver);
        actions.moveToElement(gotosignin).click();
    }
}
